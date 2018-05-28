package entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/5/28.
 */
@Entity
@Table(name = "stu_course", schema = "collegemanager", catalog = "")
public class StuCourseEntity {
    private int scId;
    private Integer scStuid;
    private Integer scCourseid;

    @Id
    @Column(name = "sc_id", nullable = false)
    public int getScId() {
        return scId;
    }

    public void setScId(int scId) {
        this.scId = scId;
    }

    @Basic
    @Column(name = "sc_stuid", nullable = true)
    public Integer getScStuid() {
        return scStuid;
    }

    public void setScStuid(Integer scStuid) {
        this.scStuid = scStuid;
    }

    @Basic
    @Column(name = "sc_courseid", nullable = true)
    public Integer getScCourseid() {
        return scCourseid;
    }

    public void setScCourseid(Integer scCourseid) {
        this.scCourseid = scCourseid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuCourseEntity that = (StuCourseEntity) o;

        if (scId != that.scId) return false;
        if (scStuid != null ? !scStuid.equals(that.scStuid) : that.scStuid != null) return false;
        if (scCourseid != null ? !scCourseid.equals(that.scCourseid) : that.scCourseid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scId;
        result = 31 * result + (scStuid != null ? scStuid.hashCode() : 0);
        result = 31 * result + (scCourseid != null ? scCourseid.hashCode() : 0);
        return result;
    }
}
