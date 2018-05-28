package entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/5/28.
 */
@Entity
@Table(name = "tbl_class", schema = "collegemanager", catalog = "")
public class TblClassEntity {
    private int classId;
    private String className;
    private Integer classSysid;

    @Id
    @Column(name = "class_id", nullable = false)
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "class_name", nullable = true, length = 20)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "class_sysid", nullable = true)
    public Integer getClassSysid() {
        return classSysid;
    }

    public void setClassSysid(Integer classSysid) {
        this.classSysid = classSysid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblClassEntity that = (TblClassEntity) o;

        if (classId != that.classId) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (classSysid != null ? !classSysid.equals(that.classSysid) : that.classSysid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (classSysid != null ? classSysid.hashCode() : 0);
        return result;
    }
}
