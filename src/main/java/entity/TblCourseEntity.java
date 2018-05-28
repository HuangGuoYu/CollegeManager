package entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/5/28.
 */
@Entity
@Table(name = "tbl_course", schema = "collegemanager", catalog = "")
public class TblCourseEntity {
    private int courseId;
    private String courseName;
    private Integer courseSysname;
    private String courseAddress;
    private String courseTime;

    @Id
    @Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_name", nullable = true, length = 20)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_sysname", nullable = true)
    public Integer getCourseSysname() {
        return courseSysname;
    }

    public void setCourseSysname(Integer courseSysname) {
        this.courseSysname = courseSysname;
    }

    @Basic
    @Column(name = "course_address", nullable = true, length = 50)
    public String getCourseAddress() {
        return courseAddress;
    }

    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }

    @Basic
    @Column(name = "course_time", nullable = true, length = 50)
    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblCourseEntity that = (TblCourseEntity) o;

        if (courseId != that.courseId) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (courseSysname != null ? !courseSysname.equals(that.courseSysname) : that.courseSysname != null)
            return false;
        if (courseAddress != null ? !courseAddress.equals(that.courseAddress) : that.courseAddress != null)
            return false;
        if (courseTime != null ? !courseTime.equals(that.courseTime) : that.courseTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseSysname != null ? courseSysname.hashCode() : 0);
        result = 31 * result + (courseAddress != null ? courseAddress.hashCode() : 0);
        result = 31 * result + (courseTime != null ? courseTime.hashCode() : 0);
        return result;
    }
}
