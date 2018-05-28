package utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CqustClient {
    private static final String BASE_URL = "http://cas.cqust.edu.cn";

    private Map<String, String> loginPageCookie = new HashMap<>();
    private Document loginPage = null;

    //访问登录页面，主要目的是拿到cookie和登录表单
    private void getLoginPageResponse() throws IOException {
        if (loginPage == null || loginPageCookie.isEmpty()) {
            //访问登录页面
            Connection.Response response = Jsoup.connect(BASE_URL + "/authserver/login?service=http://ehall.cqust.edu.cn/index.portal")
                    .method(Connection.Method.GET)
                    .execute();
            loginPageCookie.clear();
            loginPageCookie.putAll(response.cookies());
            loginPage = response.parse();
        }
    }

    //检查账号登录是否需要验证码
    public String needCaptcha(String username) {
        try {
            getLoginPageResponse();
            Document document = Jsoup.connect(BASE_URL + "/authserver/needCaptcha.html?username=" + username)
                    .cookies(loginPageCookie)
                    .get();
            return document.body().text().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }

    //获取登陆所需的验证码
    public byte[] getCaptcha() throws IOException {
        getLoginPageResponse();
        Connection.Response response = Jsoup.connect(BASE_URL + "/authserver/captcha.html")
                .ignoreContentType(true)
                .cookies(loginPageCookie)
                .method(Connection.Method.GET)
                .execute();
        return response.bodyAsBytes();
    }

    //返回通行证：cookie
    public Map<String, String> getLoginedCookie(String username, String password, String captcha) {
        Map<String, String> cookies = null;
        try {
            getLoginPageResponse();
            Element body = loginPage.body();
            Element form = body.getElementById("casLoginForm");
            Elements elements = form.select("input[type='hidden']");
            Map<String, String> data = new HashMap<>();
            for (Element element : elements) {
                data.put(element.attr("name"), element.attr("value"));
            }
            data.put("username", username);
            data.put("password", password);
            if (captcha != null) {
                data.put("captchaResponse", captcha);
            }
            //提交登录表单
            Connection.Response response = Jsoup.connect(BASE_URL + form.attr("action"))
                    .data(data)
                    .cookies(loginPageCookie)
                    .method(Connection.Method.POST)
                    .header("Connection", "close")
                    .execute();

            body = response.parse().body();
            Elements error = body.select("form#casLoginForm > span#msg.auth_error");
            if (error.isEmpty()) {
                cookies = response.cookies();
            } else {
                cookies = new HashMap<>();
                cookies.put("loginErrorMessage", error.text());
            }
        } catch (Exception e) {
            e.printStackTrace();
            cookies = null;
        }
        loginPageCookie.clear();
        loginPage = null;
        return cookies;
    }

    //获取学生的学籍信息和住宿信息
    public Map<String, String> getPersonInfo(Map<String, String> cookies) {
        Map<String, String> info = new HashMap<>();
        if (cookies == null || cookies.isEmpty() || cookies.keySet().contains("loginErrorMessage")) {//如果有包含登录错误信息也是登录失败
            return info;
        }
        Map<String, String> xjxx = getXJXX(cookies);
        Map<String, String> dormInfo = getDormInfo(cookies);
        if (xjxx == null || xjxx.isEmpty() ||
                dormInfo == null || dormInfo.isEmpty())
            return info;
        info.putAll(xjxx);
        info.putAll(dormInfo);
        return info;
    }

    //获得课表信息
    public List<Map<String, Object>> getCourseInfo(Map<String, String> cookies) throws IOException {
        String url = "http://jwnew.cqust.edu.cn/eams/courseTableForStd!courseTable.action";
        if (cookies == null || cookies.isEmpty()) {
            return null;
        }
        Document document = Jsoup.connect(url)
                .cookies(cookies)
                .header("Connection", "close")
                .get();
        Elements elements = document.select("#grid12042826912");
        System.out.println(document.body().html());
        return null;
    }

    //获取学籍信息
    public Map<String, String> getXJXX(Map<String, String> cookies) {
        if (cookies == null || cookies.isEmpty()) {
            return null;
        }
        Map<String, String> xjxx = new HashMap<>();
        try {
            Document document = Jsoup.connect("http://jwnew.cqust.edu.cn/eams/stdDetail.action")
                    .cookies(cookies)
                    .header("Connection", "close")
                    .get();

            Elements elements = document.body().select("table#studentInfoTb > tbody td");
            for (int j = 0; j < elements.size() - 1; j++) {
                String key = elements.get(j).text().trim().replace("：", "");
                String value = elements.get(j + 1).text().trim();
                if (key.equals("学号") ||
                        key.equals("姓名") ||
                        key.equals("性别") ||
                        key.equals("学生类别") ||
                        key.equals("所在年级") ||
                        key.equals("院系") ||
                        key.equals("专业") ||
                        key.equals("行政班级") ||
                        key.equals("所属校区")) {
                    xjxx.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return xjxx;
    }

    //获取住宿信息
    public Map<String, String> getDormInfo(Map<String, String> cookies) {
        if (cookies == null || cookies.isEmpty()) {
            return null;
        }
        Map<String, String> dormInfo = new HashMap<>();
        try {
            Document document = Jsoup.connect("http://ehall.cqust.edu.cn/index.portal?.pn=p188")
                    .cookies(cookies)
                    .header("Connection", "close")
                    .get();

            String bodyStr = document.body().html();
            bodyStr = bodyStr.substring(bodyStr.indexOf("pnull.portal?rar="));
            String rar = bodyStr.substring("pnull.portal?rar=".length(), bodyStr.indexOf("&"));

            //取消所有隐藏的列，让他们显示出来
            Jsoup.connect("http://ehall.cqust.edu.cn/pnull.portal?" +
                    "rar=" + rar +
                    "&.pmn=view" +
                    "&.ia=false" +
                    "&action=saveHidenColumn" +
                    "&.pen=pe575" +
                    "&childId=240" +
                    "&columns=")
                    .cookies(cookies)
                    .header("Connection", "close")
                    .get();

            //获取住宿的信息
            document = Jsoup.connect("http://ehall.cqust.edu.cn/pnull.portal?" +
                    "rar=" + rar +
                    "&.pmn=view" +
                    "&.ia=false" +
                    "&action=showItem" +
                    "&.pen=pe575" +
                    "&itemId=231" +
                    "&childId=240" +
                    "&page=1")
                    .cookies(cookies)
                    .header("Connection", "close")
                    .get();

            Element body = document.body();
            Elements ths = body.select("table#sb_table240 > thead > tr > th");
            Elements tds = body.select("table#sb_table240 > tbody > tr > td");
            for (int i = 0; i < ths.size(); i++) {
                String thStr = ths.get(i).text().trim();
                String tdStr = tds.get(i).text().trim();
                if (thStr.equals("学生编号") || thStr.equals("校区")) {
                    continue;
                }
                dormInfo.put(thStr, tdStr);
            }

            //获取学生基本信息的页面，主要是去获取到身份证号码
            document = Jsoup.connect("http://ehall.cqust.edu.cn/pnull.portal?" +
                    "rar=" + rar +
                    "&.pmn=view" +
                    "&.ia=false" +
                    "&action=showItem" +
                    "&.pen=pe575" +
                    "&itemId=7" +
                    "&childId=21" +
                    "&page=1")
                    .cookies(cookies)
                    .header("Connection", "close")
                    .get();
            body = document.body();
            Elements elements = body.select("table.main-table td");
            dormInfo.put("身份证号", elements.get(elements.size() - 1).text());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return dormInfo;
    }
}
