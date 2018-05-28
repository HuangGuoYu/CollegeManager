package controller.pc;

import common.BaseController;
import dao.BaseDao;
import entity.SysUserEntity;
import entity.TblCourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import resp.GeneralResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class teacher extends BaseController {
    @Autowired
    @Qualifier("stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource(name = "javaMailSenderImpl")
    private JavaMailSender sender;


    @Autowired
    private BaseDao baseDao;

    @RequestMapping("/signin")
    @ResponseBody
    public GeneralResult signin(HttpServletRequest request, HttpSession session) {
        //System.out.println("点名功能");
        GeneralResult result = new GeneralResult();
        String hql = "from TblCourseEntity where courseSysname = :username";
        Map<String, Object> parms = new HashMap<>();
        SysUserEntity user = (SysUserEntity) session.getAttribute("user");
        parms.put("username",user.getSysId());
        List<Object> dbentity = baseDao.findEntityByHql(hql, parms);
        return result.ok(dbentity);
    }

    @RequestMapping("/test")
    public String test() {
        return "teacher/signinjsp";
    }
}