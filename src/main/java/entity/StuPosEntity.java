package entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Administrator on 2018/5/28.
 */
@Entity
@Table(name = "stu_pos", schema = "collegemanager", catalog = "")
public class StuPosEntity {
    private int spId;
    private Integer spStuid;
    private Time spTime;
    private String spPeriod;
    private String spX;
    private String spY;
    private Integer spStatus;

    @Id
    @Column(name = "sp_id", nullable = false)
    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    @Basic
    @Column(name = "sp_stuid", nullable = true)
    public Integer getSpStuid() {
        return spStuid;
    }

    public void setSpStuid(Integer spStuid) {
        this.spStuid = spStuid;
    }

    @Basic
    @Column(name = "sp_time", nullable = true)
    public Time getSpTime() {
        return spTime;
    }

    public void setSpTime(Time spTime) {
        this.spTime = spTime;
    }

    @Basic
    @Column(name = "sp_period", nullable = true, length = 30)
    public String getSpPeriod() {
        return spPeriod;
    }

    public void setSpPeriod(String spPeriod) {
        this.spPeriod = spPeriod;
    }

    @Basic
    @Column(name = "sp_x", nullable = true, length = 30)
    public String getSpX() {
        return spX;
    }

    public void setSpX(String spX) {
        this.spX = spX;
    }

    @Basic
    @Column(name = "sp_y", nullable = true, length = 30)
    public String getSpY() {
        return spY;
    }

    public void setSpY(String spY) {
        this.spY = spY;
    }

    @Basic
    @Column(name = "sp_status", nullable = true)
    public Integer getSpStatus() {
        return spStatus;
    }

    public void setSpStatus(Integer spStatus) {
        this.spStatus = spStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuPosEntity that = (StuPosEntity) o;

        if (spId != that.spId) return false;
        if (spStuid != null ? !spStuid.equals(that.spStuid) : that.spStuid != null) return false;
        if (spTime != null ? !spTime.equals(that.spTime) : that.spTime != null) return false;
        if (spPeriod != null ? !spPeriod.equals(that.spPeriod) : that.spPeriod != null) return false;
        if (spX != null ? !spX.equals(that.spX) : that.spX != null) return false;
        if (spY != null ? !spY.equals(that.spY) : that.spY != null) return false;
        if (spStatus != null ? !spStatus.equals(that.spStatus) : that.spStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spId;
        result = 31 * result + (spStuid != null ? spStuid.hashCode() : 0);
        result = 31 * result + (spTime != null ? spTime.hashCode() : 0);
        result = 31 * result + (spPeriod != null ? spPeriod.hashCode() : 0);
        result = 31 * result + (spX != null ? spX.hashCode() : 0);
        result = 31 * result + (spY != null ? spY.hashCode() : 0);
        result = 31 * result + (spStatus != null ? spStatus.hashCode() : 0);
        return result;
    }
}
