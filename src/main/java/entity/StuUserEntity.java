package entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/5/28.
 */
@Entity
@Table(name = "stu_user", schema = "collegemanager", catalog = "")
public class StuUserEntity {
    private int stuId;
    private String stuUsername;
    private String stuPassword;
    private String stuName;
    private String stuGender;
    private String stuTel;
    private String sysEmail;
    private Integer stuClassid;

    @Id
    @Column(name = "stu_id", nullable = false)
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "stu_username", nullable = true, length = 20)
    public String getStuUsername() {
        return stuUsername;
    }

    public void setStuUsername(String stuUsername) {
        this.stuUsername = stuUsername;
    }

    @Basic
    @Column(name = "stu_password", nullable = true, length = 20)
    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    @Basic
    @Column(name = "stu_name", nullable = true, length = 20)
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Basic
    @Column(name = "stu_gender", nullable = true, length = 20)
    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    @Basic
    @Column(name = "stu_tel", nullable = true, length = 20)
    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    @Basic
    @Column(name = "sys_email", nullable = true, length = 50)
    public String getSysEmail() {
        return sysEmail;
    }

    public void setSysEmail(String sysEmail) {
        this.sysEmail = sysEmail;
    }

    @Basic
    @Column(name = "stu_classid", nullable = true)
    public Integer getStuClassid() {
        return stuClassid;
    }

    public void setStuClassid(Integer stuClassid) {
        this.stuClassid = stuClassid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuUserEntity entity = (StuUserEntity) o;

        if (stuId != entity.stuId) return false;
        if (stuUsername != null ? !stuUsername.equals(entity.stuUsername) : entity.stuUsername != null) return false;
        if (stuPassword != null ? !stuPassword.equals(entity.stuPassword) : entity.stuPassword != null) return false;
        if (stuName != null ? !stuName.equals(entity.stuName) : entity.stuName != null) return false;
        if (stuGender != null ? !stuGender.equals(entity.stuGender) : entity.stuGender != null) return false;
        if (stuTel != null ? !stuTel.equals(entity.stuTel) : entity.stuTel != null) return false;
        if (sysEmail != null ? !sysEmail.equals(entity.sysEmail) : entity.sysEmail != null) return false;
        if (stuClassid != null ? !stuClassid.equals(entity.stuClassid) : entity.stuClassid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuId;
        result = 31 * result + (stuUsername != null ? stuUsername.hashCode() : 0);
        result = 31 * result + (stuPassword != null ? stuPassword.hashCode() : 0);
        result = 31 * result + (stuName != null ? stuName.hashCode() : 0);
        result = 31 * result + (stuGender != null ? stuGender.hashCode() : 0);
        result = 31 * result + (stuTel != null ? stuTel.hashCode() : 0);
        result = 31 * result + (sysEmail != null ? sysEmail.hashCode() : 0);
        result = 31 * result + (stuClassid != null ? stuClassid.hashCode() : 0);
        return result;
    }
}
