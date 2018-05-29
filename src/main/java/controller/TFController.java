package controller;

import common.BaseController;
import entity.TblPostEntity;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import resp.GeneralResult;
import service.mobile.FuDaoService;
import sun.security.jgss.wrapper.GSSNameElement;

@RestController
@RequestMapping("/tf")
public class TFController extends BaseController {

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


    /**
     * 查询公告信息（传教师id查询所有公告信息，id不传查询所有公告信息）
     * @param p_userid
     * @return
     */
    @RequestMapping(value = "/getAnnouncementByTeacherId",method = RequestMethod.POST)
    public GeneralResult getListAnnouncement(@RequestParam(value = "p_userid",required = false) Integer p_userid){
        GeneralResult result;
        if (p_userid != null){
            result = fuDaoService.getAnnouncementByTeacherId(p_userid);
        }else {
            result = fuDaoService.getListAnnouncement();
        }
        return result;
    }


    /**
     * 添加公告信息
     * @param tblPostEntity
     * @return
     */
    @RequestMapping(value = "/addAnnouncement",method = RequestMethod.POST)
    public GeneralResult addAnnouncement(@RequestBody TblPostEntity tblPostEntity){
        GeneralResult result;
        result = fuDaoService.addAnnouncement(tblPostEntity);
        return result;
    }

    /**
     * 删除公告信息
     * @param p_id
     * @return
     */
    @RequestMapping(value = "/deleteAnnouncement/{p_id}",method = RequestMethod.GET)
    public GeneralResult deleteAnnouncement(@RequestParam("p_id") Integer p_id){
        GeneralResult result;
        result = fuDaoService.deleteAnnouncement(p_id);
        return result;
    }

}
