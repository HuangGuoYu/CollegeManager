package service.mobile.impl;

import dao.BaseDao;
import entity.StuUserEntity;
import entity.TblClassEntity;
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
        String hql = "from TblClassEntity where class_sysid = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<TblClassEntity> tbs = baseDao.findEntityByHql(hql,params);
        for (TblClassEntity tb: tbs) {
            System.out.println(tb.getClassName());
        }
        result.ok(200,tbs);
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
}
