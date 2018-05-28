package controller;

import common.BaseController;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import resp.GeneralResult;
import service.mobile.FuDaoService;

@RestController
@RequestMapping("/tf")
public class SysUserController extends BaseController {

    @Autowired
    private FuDaoService fuDaoService;

    /**
     *  通过辅导员id查询有哪些班级（辅导员id不传表示查询所有班级）
     * @param id required = false
     * @return
     */
    @RequestMapping(value = "/getClassBySys_userId",method = RequestMethod.POST)
    public GeneralResult getBackSchoolStuBySys_userId(@RequestParam(value="id",required = false) Integer id){
        GeneralResult result;
        if (id != null){
            System.err.println("id不为空");
            result = fuDaoService.getBackSchoolStuBySys_userId(id);
        }else{
            System.err.println("id为空");
            result = fuDaoService.getBackSchoolStuBySys();

        }
        return result;
    }


    /**
     *查询某个班的所有学生信息
     * @param stu_classid
     * @return
     */
    @RequestMapping(value = "/getListStuByClassId/{stu_classid}",method = RequestMethod.GET)
    public GeneralResult getListStuByClassId(@PathVariable Integer stu_classid){
        GeneralResult result;
        result = fuDaoService.getListStuByClassId(stu_classid);
        return result;
    }


}
