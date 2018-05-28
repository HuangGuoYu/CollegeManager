package controller.pc;

import common.BaseController;
import dao.BaseDao;
import entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import resp.GeneralResult;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class ZhuzhuController extends BaseController {

    @Autowired
    private BaseDao baseDao;

    @RequestMapping("/findAllCourse")
    @ResponseBody
    public GeneralResult findAllCourse(){
        SysUserEntity sessionSysUser = getSessionSysUser();
        //获取老师ID
        int sysId = sessionSysUser.getSysId();
        //查询当前老师对应的课程 SELECT * from tbl_course where  course_sysname = 1;
        String sql="SELECT * from tbl_course where  course_sysname = "+String.valueOf(sysId);
        //查询
        List<Map<String, Object>> bySql = baseDao.findBySql(sql, null);
        //返回
        return new GeneralResult().ok(bySql);
    }

    @RequestMapping("/findCourseList")
    @ResponseBody
    public  GeneralResult findCourseList(int courseID){

        //查询所有课
        String sql="SELECT  a.* ,b.course_name FROM course_list a " +
                "INNER JOIN tbl_course b ON a.cl_courseid = b.course_id WHERE a.cl_courseid = "+String.valueOf(courseID);
        List<Map<String, Object>> bySql = baseDao.findBySql(sql, null);
        //返回结果
        return new GeneralResult().ok(bySql);
    }

    @RequestMapping("/queryStudentSign")
    @ResponseBody
    public  GeneralResult queryStudentSign(int ss_courseListId ){

        //sql
        String sql="select a.* ,b.* from stu_sign a LEFT JOIN stu_user b on a.ss_stuid=b.stu_id " +
                "where a.ss_courseListId="+String.valueOf(ss_courseListId);
        List<Map<String, Object>> bySql = baseDao.findBySql(sql, null);
        //返回结果
        return new GeneralResult().ok(bySql);
    }


}
