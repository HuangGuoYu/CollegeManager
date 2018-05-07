package entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2018/5/7.
 */
@Entity
@Table(name = "stu_sign", schema = "collegemanager", catalog = "")
public class StuSignEntity {
    private int ssId;
    private Integer ssStuid;
    private Integer ssCourseid;
    private Integer ssStatus;
    private Date ssDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ss_id", nullable = false)
    public int getSsId() {
        return ssId;
    }

    public void setSsId(int ssId) {
        this.ssId = ssId;
    }

    @Basic
    @Column(name = "ss_stuid", nullable = true)
    public Integer getSsStuid() {
        return ssStuid;
    }

    public void setSsStuid(Integer ssStuid) {
        this.ssStuid = ssStuid;
    }

    @Basic
    @Column(name = "ss_courseid", nullable = true)
    public Integer getSsCourseid() {
        return ssCourseid;
    }

    public void setSsCourseid(Integer ssCourseid) {
        this.ssCourseid = ssCourseid;
    }

    @Basic
    @Column(name = "ss_status", nullable = true)
    public Integer getSsStatus() {
        return ssStatus;
    }

    public void setSsStatus(Integer ssStatus) {
        this.ssStatus = ssStatus;
    }

    @Basic
    @Column(name = "ss_date", nullable = true)
    public Date getSsDate() {
        return ssDate;
    }

    public void setSsDate(Date ssDate) {
        this.ssDate = ssDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuSignEntity that = (StuSignEntity) o;

        if (ssId != that.ssId) return false;
        if (ssStuid != null ? !ssStuid.equals(that.ssStuid) : that.ssStuid != null) return false;
        if (ssCourseid != null ? !ssCourseid.equals(that.ssCourseid) : that.ssCourseid != null) return false;
        if (ssStatus != null ? !ssStatus.equals(that.ssStatus) : that.ssStatus != null) return false;
        if (ssDate != null ? !ssDate.equals(that.ssDate) : that.ssDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssId;
        result = 31 * result + (ssStuid != null ? ssStuid.hashCode() : 0);
        result = 31 * result + (ssCourseid != null ? ssCourseid.hashCode() : 0);
        result = 31 * result + (ssStatus != null ? ssStatus.hashCode() : 0);
        result = 31 * result + (ssDate != null ? ssDate.hashCode() : 0);
        return result;
    }
}
