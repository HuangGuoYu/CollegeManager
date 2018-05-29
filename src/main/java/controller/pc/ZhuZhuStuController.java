package controller.pc;

import common.BaseController;
import dao.BaseDao;
import entity.StuLeaveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import resp.GeneralResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class ZhuZhuStuController extends BaseController {


    @Autowired
    private BaseDao baseDao;



    @RequestMapping("/queryStudentById")
    public String queryStudentById(int id){

        //sql语句
        String sql="SELECT stu_user.*,tbl_class.*,sys_user.sys_name from stu_user LEFT JOIN tbl_class on stu_user.stu_classid=tbl_class.class_id " +
                " LEFT JOIN sys_user on sys_user.sys_id=tbl_class.class_sysid  WHERE stu_id ="+String.valueOf(id);
        //查询
        List<Map<String, Object>> bySql = baseDao.findBySql(sql, null);
        request.setAttribute("user",bySql.get(0));
        return  "studentInfo";
    }

    @RequestMapping("/leave")
    @ResponseBody
    public GeneralResult leave(StuLeaveEntity stuLeaveEntity){

        baseDao.execEntitySave(stuLeaveEntity);

        return new GeneralResult().ok(true);
    }

    @RequestMapping("/queryClaaById")
    public String queryClaaById(int id ){
        String sql="select * from stu_location_course where stu_id ="+String.valueOf(id);
        List<Map<String, Object>> bySql = baseDao.findBySql(sql, null);
        request.setAttribute("user",bySql.get(0));
        return "queryClassById";
    }

    @RequestMapping("/test")
    public String test(){

        return "studentLeave";
    }


}

