package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/7.
 */
public class TestCapture {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://cas.cqust.edu.cn/authserver/login?service=http://ehall.cqust.edu.cn/index.portal");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);//允许连接提交信息
            connection.setRequestMethod("POST");//网页提交方式“GET”、“POST”
            connection.setRequestProperty("User-Agent", "Mozilla/4.7 [en] (Win98; I)");
            StringBuffer sb = new StringBuffer();
            sb.append("username=2014441449");
            sb.append("&password=hgy+1996");
            sb.append("&lt=LT-786154-drHO1YdeG64h2MldkMoBhAra7ZTWQv1525634562580-vi4g-cas");
            sb.append("&dllt=userNamePasswordLogin");
//            sb.append("&execution=els1");
            sb.append("&_eventId=submit");
            sb.append("&rmShown=1");
            OutputStream os = connection.getOutputStream();
            os.write(sb.toString().getBytes());
            os.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String responseCookie = connection.getHeaderField("Set-Cookie");//取到所用的Cookie
            System.out.println("cookie:" + responseCookie);
            String line = br.readLine();
            while (line != null) {
                System.out.println(new String(line.getBytes()));
                line = br.readLine();//打出登录的网页
            }

            //acces
            URL url1 = new URL("http://ehall.cqust.edu.cn/index.portal");
            HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();
            System.out.println(connection.getHeaderField(6));
            System.out.println(connection.getHeaderField(11));
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            System.out.println(connection.getHeaderField("Set-Cookie"));
            List<String> strings = headerFields.get("Set-Cookie");
            String cookiespre = "";
            String cookiessuf = "";
            for (String string : strings) {
                if (string.contains("route")) {
                    cookiespre = string;
                } else {
                    cookiessuf = string;
                }
            }
            String cookie = cookiespre + "; " +  cookiessuf;
            String cookie2 = "route=441d13164c1c723f38e98fb6e8a67304; JSESSIONID=0000xdqWbppcVXO_fqVE8-1qoLY:1anjjprer; iPlanetDirectoryPro=AQIC5wM2LY4Sfcxf2pBFiVPk15TszK7mYI9z6fDj0rzDmKI%3D%40AAJTSQACMDE%3D%23";
            connection1.setRequestProperty("Cookie", cookie2);//给服务器送登录后的cookie
            BufferedReader br1 = new BufferedReader(new InputStreamReader(connection1.getInputStream()));
            String line1= br1.readLine();
            while (line1 != null) {
                System.out.println(new String(line1.getBytes()));
                line1 = br1.readLine();
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
