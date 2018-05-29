package controller.pc;

import common.BaseController;
import dao.BaseDao;
import entity.StuLeaveEntity;
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
@RequestMapping("/counselor")
public class czt extends BaseController {
    @Autowired
    @Qualifier("stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource(name = "javaMailSenderImpl")
    private JavaMailSender sender;


    @Autowired
    private BaseDao baseDao;

    //辅导员查看本班级申请请假的人
    @RequestMapping("/Apply")
    @ResponseBody
    public GeneralResult Applyleave(HttpServletRequest request, HttpSession session) {
        GeneralResult result = new GeneralResult();
        SysUserEntity sessionSysUser = getSessionSysUser();
        String hql = "select stu_leave.*,stu_user.* from  stu_leave,stu_user where sl_stuid in (\n" +
                "select stu_id from stu_user where stu_classid in (select class_id from tbl_class where class_sysid = :sysUserId)) \n" +
                "and sl_status = 1 and sl_stuid = stu_id";
        Map<String, Object> parms = new HashMap<>();
        SysUserEntity user = (SysUserEntity) session.getAttribute("user");
        parms.put("sysUserId",user.getSysId());
        List<Object> dbentity = baseDao.findEntityByHql(hql, parms);
        return result.ok(dbentity);
    }

    //辅导员查看本班级的请假结果
    @RequestMapping("/leaveResult")
    @ResponseBody
    public GeneralResult leaveResult(HttpServletRequest request, HttpSession session) {
        GeneralResult result = new GeneralResult();
        SysUserEntity sessionSysUser = getSessionSysUser();
        String hql = "select stu_leave.*,stu_user.* from  stu_leave,stu_user where sl_stuid in (\n" +
                "select stu_id from stu_user where stu_classid in (select class_id from tbl_class where class_sysid = :sysUserId)) \n" +
                "and sl_status <> 1 and sl_stuid = stu_id";
        Map<String, Object> parms = new HashMap<>();
        SysUserEntity user = (SysUserEntity) session.getAttribute("user");
        parms.put("sysUserId",user.getSysId());
        List<Object> dbentity = baseDao.findEntityByHql(hql, parms);
        return result.ok(dbentity);
    }

    //辅导员查批准/驳回请假
    @RequestMapping("/leaveReview")
    @ResponseBody
    public GeneralResult leaveReview(HttpServletRequest request, HttpSession session, StuLeaveEntity stuLeaveEntity) {
        baseDao.execEntityUpdate(stuLeaveEntity);
        GeneralResult result = new GeneralResult();
        return result.ok(200,request);
    }

    @RequestMapping("/test")
    public String test() {
        return "teacher/signinjsp";
    }
}