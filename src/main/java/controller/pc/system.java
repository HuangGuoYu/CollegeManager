package controller.pc;


import common.BaseController;
import dao.BaseDao;
import entity.StuCourseEntity;
import entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import resp.GeneralResult;
import utils.ServletUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class system extends BaseController {
    @Autowired
    @Qualifier("stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource(name = "javaMailSenderImpl")
    private JavaMailSender sender;


    @Autowired private BaseDao baseDao;

    @RequestMapping("/login")
    @ResponseBody
    public GeneralResult login(HttpServletRequest request, HttpSession session, SysUserEntity user) {
        GeneralResult result = new GeneralResult();
        String hql = "from SysUserEntity where sysUsername = :username and sysPassword = :password and sysIdentity = :identity";
        Map<String,Object>parms = new HashMap<>();
        parms.put("username",user.getSysUsername());
        parms.put("password",user.getSysPassword());
        parms.put("identity",user.getSysIdentity());
        List<Object> dbentity = baseDao.findEntityByHql(hql,parms);
        if(dbentity.size()!=0){
            System.out.println("查到");
            session.setAttribute("user",dbentity.get(0));
            ServletUtils.setSysUser(request,(SysUserEntity)dbentity.get(0));
            return result.ok(dbentity);
        }
        else {
            System.out.println("未查到");
            return result.error(0,"账号或密码错误");
        }

    }
}
