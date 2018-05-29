package entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Administrator on 2018/5/28.
 */
@Entity
@Table(name = "stu_leave", schema = "collegemanager", catalog = "")
public class StuLeaveEntity {
    private int slId;
    private Integer slStuid;
    private String slReason;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date slBegindate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date slEnddate;
    private Integer slStatus;

    @Id
    @Column(name = "sl_id", nullable = false)
    public int getSlId() {
        return slId;
    }

    public void setSlId(int slId) {
        this.slId = slId;
    }

    @Basic
    @Column(name = "sl_stuid", nullable = true)
    public Integer getSlStuid() {
        return slStuid;
    }

    public void setSlStuid(Integer slStuid) {
        this.slStuid = slStuid;
    }

    @Basic
    @Column(name = "sl_reason", nullable = true, length = 500)
    public String getSlReason() {
        return slReason;
    }

    public void setSlReason(String slReason) {
        this.slReason = slReason;
    }

    @Basic
    @Column(name = "sl_begindate", nullable = true)
    public Date getSlBegindate() {
        return slBegindate;
    }

    public void setSlBegindate(Date slBegindate) {
        this.slBegindate = slBegindate;
    }

    @Basic
    @Column(name = "sl_enddate", nullable = true)
    public Date getSlEnddate() {
        return slEnddate;
    }

    public void setSlEnddate(Date slEnddate) {
        this.slEnddate = slEnddate;
    }

    @Basic
    @Column(name = "sl_status", nullable = true)
    public Integer getSlStatus() {
        return slStatus;
    }

    public void setSlStatus(Integer slStatus) {
        this.slStatus = slStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuLeaveEntity that = (StuLeaveEntity) o;

        if (slId != that.slId) return false;
        if (slStuid != null ? !slStuid.equals(that.slStuid) : that.slStuid != null) return false;
        if (slReason != null ? !slReason.equals(that.slReason) : that.slReason != null) return false;
        if (slBegindate != null ? !slBegindate.equals(that.slBegindate) : that.slBegindate != null) return false;
        if (slEnddate != null ? !slEnddate.equals(that.slEnddate) : that.slEnddate != null) return false;
        if (slStatus != null ? !slStatus.equals(that.slStatus) : that.slStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = slId;
        result = 31 * result + (slStuid != null ? slStuid.hashCode() : 0);
        result = 31 * result + (slReason != null ? slReason.hashCode() : 0);
        result = 31 * result + (slBegindate != null ? slBegindate.hashCode() : 0);
        result = 31 * result + (slEnddate != null ? slEnddate.hashCode() : 0);
        result = 31 * result + (slStatus != null ? slStatus.hashCode() : 0);
        return result;
    }
}
