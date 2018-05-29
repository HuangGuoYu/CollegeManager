package service.mobile.impl;

import dao.BaseDao;
import entity.StuUserEntity;
import entity.TblClassEntity;
import entity.TblPostEntity;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resp.GeneralResult;
import service.mobile.FuDaoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FuDaoServiceImpl implements FuDaoService {

    @Autowired
    private BaseDao baseDao;


    @Override
    public GeneralResult getBackSchoolStuBySys_userId(Integer id) {
        GeneralResult result = new GeneralResult();
        String hql = "SELECT * from \n" +
                "(\n" +
                "SELECT tbl_class.*,count(stu_id) as stucount \n" +
                "FROM  tbl_class,stu_user \n" +
                "where class_sysid = :id and class_id = stu_classid group by class_id\n" +
                ") a LEFT JOIN\n" +
                "(\n" +
                "SELECT b.stu_classid,COUNT(0) num from stu_pos a \n" +
                "LEFT JOIN stu_user b on a.sp_stuid = b.stu_id\n" +
                "LEFT JOIN tbl_class c on b.stu_classid = c.class_id\n" +
                "GROUP BY stu_classid \n" +
                ") b on a.class_id = b.stu_classid";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<Map<String, Object>> bySql = baseDao.findBySql(hql, params);

        result.ok(200,bySql);
        return result;
    }

    @Override
    public GeneralResult getBackSchoolStuBySys() {
        GeneralResult result = new GeneralResult();
        String hql = "SELECT * from \n" +
                "(\n" +
                "SELECT tbl_class.*,count(stu_id) as stucount \n" +
                "FROM  tbl_class,stu_user \n" +
                "where class_id = stu_classid group by class_id\n" +
                ") a LEFT JOIN\n" +
                "(\n" +
                "SELECT b.stu_classid,COUNT(0) num from stu_pos a \n" +
                "LEFT JOIN stu_user b on a.sp_stuid = b.stu_id\n" +
                "LEFT JOIN tbl_class c on b.stu_classid = c.class_id\n" +
                "GROUP BY stu_classid \n" +
                ") b on a.class_id = b.stu_classid";
        List<Map<String, Object>> tbs = baseDao.findBySql(hql, null);
        result.ok(200,tbs);
        return result;
    }

    @Override
    public GeneralResult getListStuByClassId(Integer stu_classid) {
        GeneralResult result = new GeneralResult();
        String hql = "select stu_user.stu_name,stu_user.stu_username,stu_pos.sp_status ,stu_pos.sp_time,stu_leave.sl_begindate,stu_leave.sl_enddate,(\n" +
                "CASE stu_leave.sl_status\n" +
                "\tWHEN 2 THEN\n" +
                "\t\t'已请假' \n" +
                "\tELSE\n" +
                "\t\t'未请假'\n" +
                "END\n" +
                ") as l_leave \n" +
                "from stu_user left join stu_pos on stu_user.stu_id = stu_pos.sp_stuid LEFT JOIN stu_leave ON stu_leave.sl_stuid = stu_user.stu_id\n" +
                "WHERE \n" +
                "stu_user.stu_classid = :stu_classid";
        Map<String, Object> params = new HashMap<>();
        params.put("stu_classid", stu_classid);
        List<Map<String, Object>> listStu = baseDao.findBySql(hql, params);
        return result.ok(200,listStu);
    }

    @Override
    public GeneralResult getListAnnouncement() {
        GeneralResult result = new GeneralResult();
        String hql = "from TblPostEntity";
        List<Map<String, Object>> tbs = baseDao.findBySql(hql, null);
        result.ok(200,tbs);
        return result;
    }

    @Override
    public GeneralResult getAnnouncementByTeacherId(Integer p_userid) {
        GeneralResult result = new GeneralResult();
        String hql = "from TblPostEntity where p_userid = :p_userid";
        Map<String, Object> params = new HashMap<>();
        params.put("p_userid", p_userid);
        List<TblPostEntity> listStu = baseDao.findEntityByHql(hql,params);
        return result.ok(200,listStu);
    }

    @Override
    public GeneralResult addAnnouncement(TblPostEntity tblPostEntity) {
        GeneralResult result = new GeneralResult();
         try {
             baseDao.execEntitySave(tblPostEntity);
             result.ok(200,"添加成功");
         }catch (Exception e){
             result.ok(-1,"添加失败");
         }
        return result;
    }

    @Override
    public GeneralResult deleteAnnouncement(Integer p_id) {
        GeneralResult result = new GeneralResult();
        String hql = "delete from tbl_post where p_id = " + p_id;
        try {
            baseDao.execUpdate(hql, null);
            result.ok(200,"删除成功");
        } catch (Exception e) {
            result.ok(-1,"删除失败");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
