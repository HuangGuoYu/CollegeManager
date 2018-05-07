package utils;

import entity.StuUserEntity;
import entity.SysUserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/3/24.
 */
public class ServletUtils {

    public static final String USER_INFO= "USER_INFO";
    public static final String SYS_USER= "SYS_USER";

    public static StuUserEntity getUserInfo(HttpServletRequest request)  {
        HttpSession session = request.getSession();
        Object user = session.getAttribute(USER_INFO);
        return (StuUserEntity) user;
    }

    public static StuUserEntity setUserInfo(HttpServletRequest request, StuUserEntity user)  {
        HttpSession session = request.getSession();
        session.setAttribute(USER_INFO, user);
        return user;
    }

    public static StuUserEntity clearUserInfo(HttpServletRequest request)  {
        HttpSession session = request.getSession();
        StuUserEntity user = (StuUserEntity) session.getAttribute(USER_INFO);
        session.setAttribute(USER_INFO, null);
        return user;
    }

    public static SysUserEntity getSysUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SysUserEntity user = (SysUserEntity) session.getAttribute(SYS_USER);
        return user;
    }

    public static SysUserEntity setSysUser(HttpServletRequest request, SysUserEntity user) {
        HttpSession session = request.getSession();
        session.setAttribute(SYS_USER, user);
        return user;
    }

    public static void clearSysUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(SYS_USER);
    }
}
