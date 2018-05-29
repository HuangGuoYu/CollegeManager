package controller.mobile;

import common.BaseController;
import entity.StuPosEntity;
import entity.StuUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import resp.GeneralResult;
import service.mobile.UserService;
import utils.ServletUtils;

/**
 * Created by Administrator on 2018/5/7.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param sno 学号
     * @param pwd 密码
     * @return 处理结果，以及用户信息
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public GeneralResult userLogin(String sno, String pwd) {
        GeneralResult userInfo = userService.findUserInfo(sno, pwd);
        if (userInfo.getCode() == 200) {
            ServletUtils.setUserInfo(request, (StuUserEntity) userInfo.getData());
        }
        return userInfo;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping
    @ResponseBody
    public GeneralResult backSchool(StuPosEntity stuPosEntity) {
        return userService.backSchool(stuPosEntity);
    }
}
