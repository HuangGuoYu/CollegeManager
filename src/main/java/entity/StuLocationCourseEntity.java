package entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/5/28.
 */
@Entity
@Table(name = "stu_location_course", schema = "collegemanager", catalog = "")
public class StuLocationCourseEntity {
    private int slcId;
    private Integer stuId;
    private String slcTerm;
    private String slcContent;

    @Id
    @Column(name = "slc_id", nullable = false)
    public int getSlcId() {
        return slcId;
    }

    public void setSlcId(int slcId) {
        this.slcId = slcId;
    }

    @Basic
    @Column(name = "stu_id", nullable = true)
    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "slc_term", nullable = true, length = 20)
    public String getSlcTerm() {
        return slcTerm;
    }

    public void setSlcTerm(String slcTerm) {
        this.slcTerm = slcTerm;
    }

    @Basic
    @Column(name = "slc_content", nullable = true, length = 100)
    public String getSlcContent() {
        return slcContent;
    }

    public void setSlcContent(String slcContent) {
        this.slcContent = slcContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuLocationCourseEntity that = (StuLocationCourseEntity) o;

        if (slcId != that.slcId) return false;
        if (stuId != null ? !stuId.equals(that.stuId) : that.stuId != null) return false;
        if (slcTerm != null ? !slcTerm.equals(that.slcTerm) : that.slcTerm != null) return false;
        if (slcContent != null ? !slcContent.equals(that.slcContent) : that.slcContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = slcId;
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        result = 31 * result + (slcTerm != null ? slcTerm.hashCode() : 0);
        result = 31 * result + (slcContent != null ? slcContent.hashCode() : 0);
        return result;
    }
}
