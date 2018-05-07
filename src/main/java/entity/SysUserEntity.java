package entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/5/7.
 */
@Entity
@Table(name = "sys_user", schema = "collegemanager", catalog = "")
public class SysUserEntity {
    private int sysId;
    private String sysUsername;
    private String sysPassword;
    private String sysName;
    private String sysGender;
    private String sysTel;
    private String sysIdentity;
    private String sysEmail;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sys_id", nullable = false)
    public int getSysId() {
        return sysId;
    }

    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    @Basic
    @Column(name = "sys_username", nullable = true, length = 20)
    public String getSysUsername() {
        return sysUsername;
    }

    public void setSysUsername(String sysUsername) {
        this.sysUsername = sysUsername;
    }

    @Basic
    @Column(name = "sys_password", nullable = true, length = 20)
    public String getSysPassword() {
        return sysPassword;
    }

    public void setSysPassword(String sysPassword) {
        this.sysPassword = sysPassword;
    }

    @Basic
    @Column(name = "sys_name", nullable = true, length = 20)
    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    @Basic
    @Column(name = "sys_gender", nullable = true, length = 20)
    public String getSysGender() {
        return sysGender;
    }

    public void setSysGender(String sysGender) {
        this.sysGender = sysGender;
    }

    @Basic
    @Column(name = "sys_tel", nullable = true, length = 20)
    public String getSysTel() {
        return sysTel;
    }

    public void setSysTel(String sysTel) {
        this.sysTel = sysTel;
    }

    @Basic
    @Column(name = "sys_identity", nullable = true, length = 20)
    public String getSysIdentity() {
        return sysIdentity;
    }

    public void setSysIdentity(String sysIdentity) {
        this.sysIdentity = sysIdentity;
    }

    @Basic
    @Column(name = "sys_email", nullable = true, length = 50)
    public String getSysEmail() {
        return sysEmail;
    }

    public void setSysEmail(String sysEmail) {
        this.sysEmail = sysEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserEntity that = (SysUserEntity) o;

        if (sysId != that.sysId) return false;
        if (sysUsername != null ? !sysUsername.equals(that.sysUsername) : that.sysUsername != null) return false;
        if (sysPassword != null ? !sysPassword.equals(that.sysPassword) : that.sysPassword != null) return false;
        if (sysName != null ? !sysName.equals(that.sysName) : that.sysName != null) return false;
        if (sysGender != null ? !sysGender.equals(that.sysGender) : that.sysGender != null) return false;
        if (sysTel != null ? !sysTel.equals(that.sysTel) : that.sysTel != null) return false;
        if (sysIdentity != null ? !sysIdentity.equals(that.sysIdentity) : that.sysIdentity != null) return false;
        if (sysEmail != null ? !sysEmail.equals(that.sysEmail) : that.sysEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sysId;
        result = 31 * result + (sysUsername != null ? sysUsername.hashCode() : 0);
        result = 31 * result + (sysPassword != null ? sysPassword.hashCode() : 0);
        result = 31 * result + (sysName != null ? sysName.hashCode() : 0);
        result = 31 * result + (sysGender != null ? sysGender.hashCode() : 0);
        result = 31 * result + (sysTel != null ? sysTel.hashCode() : 0);
        result = 31 * result + (sysIdentity != null ? sysIdentity.hashCode() : 0);
        result = 31 * result + (sysEmail != null ? sysEmail.hashCode() : 0);
        return result;
    }
}
