package controller.pc;

import common.BaseController;
import dao.BaseDao;
import entity.StuSignEntity;

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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public GeneralResult signin(HttpServletRequest request, HttpSession session,int courseListId,int stuId) {
        System.out.println("点名功能");
        System.out.println("测试"+courseListId+stuId);
        GeneralResult <String>result = new GeneralResult();
        StuSignEntity stuSignEntity = new StuSignEntity();
        stuSignEntity.setSsStuid(stuId);
        stuSignEntity.setSsCourseListId(courseListId);
        //System.out.println(new Date());
        stuSignEntity.setSsDate(new java.sql.Date(new Date().getTime()));
        stuSignEntity.setSsStatus(1);
       try{
           baseDao.execEntitySave(stuSignEntity);
           return result.ok(200,"签到成功");
       }
        catch (Exception e){
           return result.error(500,"签到失败，请重试");
        }
    }


}