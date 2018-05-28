package service.mobile;

import resp.GeneralResult;

/**
 * Created by Administrator on 2018/5/7.
 */
public interface UserService {
    /**
     * 查找是否存在用户信息
     * @param sno 学号
     * @param pwd 密码
     * @return 处理结果
     */
    GeneralResult findUserInfo(String sno, String pwd);

    /**
     * 判断是否存在用户信息
     * @param sno 学生学号
     * @return 200 存在 ! 不存在
     */
    GeneralResult findIsExistsUserInfo(String sno);
}
