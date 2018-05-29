package service.mobile;

import entity.TblPostEntity;
import resp.GeneralResult;

public interface FuDaoService {


    GeneralResult getBackSchoolStuBySys_userId(Integer id);

    GeneralResult getBackSchoolStuBySys();

    GeneralResult getListStuByClassId(Integer stu_classid);

    GeneralResult getListAnnouncement();

    GeneralResult getAnnouncementByTeacherId(Integer p_userid);

    GeneralResult addAnnouncement(TblPostEntity tblPostEntity);

    GeneralResult deleteAnnouncement(Integer p_id);
}
