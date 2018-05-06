package controller;

import common.BaseController;
import common.ConstantCode;
import dao.BaseDao;
import entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/5/6.
 */
@Controller
@RequestMapping("/test")
public class test extends BaseController {

    @Autowired
    @Qualifier("stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource(name = "javaMailSenderImpl")
    private JavaMailSender sender;


    @Autowired private BaseDao baseDao;

    @RequestMapping("/hello")
    @ResponseBody
    public SysUser hello() {
        return baseDao.findAllEntityByClass(SysUser.class).get(0);
    }

    @RequestMapping("/mail")
    @ResponseBody
    public String testMail() {
        //构建邮件发送给消息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(ConstantCode.MAIL_HOST);
        message.setSubject("注册验证码");
        message.setTo("838937070@qq.com");
        message.setText("验证码是:" + 123456 + ";请在三分钟内使用，三分钟后验证码失效");

        //异步执行右键发送
        taskExecutor.execute(()->{
            sender.send(message);
        });
        return "ok";
    }

    @RequestMapping("/redis")
    @ResponseBody
    public String redis() {
        redisTemplate.opsForValue().set("huang", "huangguoyu");
        return redisTemplate.opsForValue().get("huang");
    }

}
