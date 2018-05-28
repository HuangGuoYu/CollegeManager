package service.mobile;

import resp.GeneralResult;

public interface FuDaoService {


    GeneralResult getBackSchoolStuBySys_userId(Integer id);

    GeneralResult getBackSchoolStuBySys();

    GeneralResult getListStuByClassId(Integer stu_classid);
}
