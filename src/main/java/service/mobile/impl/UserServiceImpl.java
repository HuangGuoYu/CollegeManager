package service.mobile.impl;

import dao.BaseDao;
import entity.StuPosEntity;
import entity.StuUserEntity;
import entity.TblClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resp.GeneralResult;
import service.mobile.UserService;
import utils.CqustClient;
import utils.DataUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/7.
 */
@Service
public class UserServiceImpl implements UserService {

    private CqustClient client = new CqustClient();

    @Autowired private BaseDao baseDao;

    @Override
    public GeneralResult findUserInfo(String sno, String pwd) {
        GeneralResult result = new GeneralResult();
        //检验数据
        if(DataUtils.strIsNullOrEmpty(sno, pwd)) {
            return result.error(201, "参数错误");
        }
        GeneralResult isExistsUserInfo = findIsExistsUserInfo(sno);
        if (isExistsUserInfo.getCode() != 200) {
            //执行爬取数据
            Map<String, String> loginedCookie = client.getLoginedCookie(sno, pwd, null);
            if (loginedCookie.keySet().contains("loginErrorMessage")) {
               return result.error(500, loginedCookie.get("loginErrorMessage") + ";由于你多次密码错误请到官网登录解除限制。");
            }
            Map<String, String> personInfo = client.getPersonInfo(loginedCookie);
            StuUserEntity entity = new StuUserEntity();
            TblClassEntity classEntity = new TblClassEntity();
            String className = personInfo.get("行政班级");
            classEntity.setClassName(className);
            String hql = "from TblClassEntity where className = :name";
            Map<String, Object> paras = new HashMap<>();
            paras.put("name", className);
            List<TblClassEntity> dbClases = baseDao.findEntityByHql(hql, paras);
            if (dbClases.size() == 0) {
                baseDao.execEntitySave(classEntity);
            }

            //根据学籍信息去查找班级信息
            entity.setStuClassid(classEntity.getClassId());
            entity.setStuUsername(sno);
            entity.setStuPassword(pwd);
            entity.setStuGender(personInfo.get("性别"));
            entity.setStuName(personInfo.get("姓名"));
            baseDao.execEntitySave(entity);

            //爬取课表信息
            try {
                client.getCourseInfo(loginedCookie);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result.ok(entity);
        }
        //直接重数据库查找
        return isExistsUserInfo;
    }

    @Override
    public GeneralResult backSchool(StuPosEntity stuPosEntity) {
        GeneralResult<String> result = new GeneralResult();
        Date date = new Date();
        stuPosEntity.setSpTime(date);
        stuPosEntity.setSpStatus(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String curDateStr = simpleDateFormat.format(date);
        String sql = "select sp_id  from stu_pos where sp_stuid=:uid and date_format(sp_time,'%Y-%m-%d')=:curDate";
        Map<String, Object> params = new HashMap<>();
        params.put("uid", stuPosEntity.getSpStuid());
        params.put("curDate", curDateStr);
        List<Map<String, Object>> count = baseDao.findBySql(sql, params);
        if (count.size() != 0) {
            return result.error(401, "当前已经成功签到返校");
        }
        baseDao.execEntitySave(stuPosEntity);
        result.setMsg("返校成功");
        return result;
    }

    @Override
    public GeneralResult findIsExistsUserInfo(String sno) {
        GeneralResult result = new GeneralResult();
        String sql = "from StuUserEntity where stuUsername = :uname";
        Map<String, Object> params = new HashMap<>();
        params.put("uname", sno);
        List<StuUserEntity> entitys = baseDao.findEntityByHql(sql, params);
        if (entitys.size() == 0) {
            return result.error(201, "不存在");
        }
        return result.ok(entitys.get(0));
    }
}
