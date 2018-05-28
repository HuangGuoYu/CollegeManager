package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/5/28.
 */
@Entity
@Table(name = "course_list", schema = "collegemanager", catalog = "")
public class CourseListEntity {
    private int clId;
    private Integer clCourseid;
    private Timestamp clTime;

    @Id
    @Column(name = "cl_id", nullable = false)
    public int getClId() {
        return clId;
    }

    public void setClId(int clId) {
        this.clId = clId;
    }

    @Basic
    @Column(name = "cl_courseid", nullable = true)
    public Integer getClCourseid() {
        return clCourseid;
    }

    public void setClCourseid(Integer clCourseid) {
        this.clCourseid = clCourseid;
    }

    @Basic
    @Column(name = "cl_time", nullable = true)
    public Timestamp getClTime() {
        return clTime;
    }

    public void setClTime(Timestamp clTime) {
        this.clTime = clTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseListEntity that = (CourseListEntity) o;

        if (clId != that.clId) return false;
        if (clCourseid != null ? !clCourseid.equals(that.clCourseid) : that.clCourseid != null) return false;
        if (clTime != null ? !clTime.equals(that.clTime) : that.clTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clId;
        result = 31 * result + (clCourseid != null ? clCourseid.hashCode() : 0);
        result = 31 * result + (clTime != null ? clTime.hashCode() : 0);
        return result;
    }
}
