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
        String hql = "from TblClassEntity";
        List<TblClassEntity> tbs = baseDao.findEntityByHql(hql,null);
        result.ok(200,tbs);
        return result;
    }

    @Override
    public GeneralResult getListStuByClassId(Integer stu_classid) {
        GeneralResult result = new GeneralResult();
        String hql = "from StuUserEntity where stu_classid = :stu_classid";
        Map<String, Object> params = new HashMap<>();
        params.put("stu_classid", stu_classid);
        List<StuUserEntity> listStu = baseDao.findEntityByHql(hql,params);
        return result.ok(200,listStu);
    }

    @Override
    public GeneralResult getListAnnouncement() {
        GeneralResult result = new GeneralResult();
        String hql = "from TblPostEntity";
        List<TblPostEntity> tbs = baseDao.findEntityByHql(hql,null);
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
