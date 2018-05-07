package entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2018/5/7.
 */
@Entity
@Table(name = "tbl_post", schema = "collegemanager", catalog = "")
public class TblPostEntity {
    private int pId;
    private Date pDate;
    private Integer pUserid;
    private Integer pIden;
    private String pTitle;
    private String pContrent;
    private String pStu;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "p_id", nullable = false)
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "p_date", nullable = true)
    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    @Basic
    @Column(name = "p_userid", nullable = true)
    public Integer getpUserid() {
        return pUserid;
    }

    public void setpUserid(Integer pUserid) {
        this.pUserid = pUserid;
    }

    @Basic
    @Column(name = "p_iden", nullable = true)
    public Integer getpIden() {
        return pIden;
    }

    public void setpIden(Integer pIden) {
        this.pIden = pIden;
    }

    @Basic
    @Column(name = "p_title", nullable = true, length = 50)
    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    @Basic
    @Column(name = "p_contrent", nullable = true, length = 1000)
    public String getpContrent() {
        return pContrent;
    }

    public void setpContrent(String pContrent) {
        this.pContrent = pContrent;
    }

    @Basic
    @Column(name = "p_stu", nullable = true, length = 20)
    public String getpStu() {
        return pStu;
    }

    public void setpStu(String pStu) {
        this.pStu = pStu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblPostEntity that = (TblPostEntity) o;

        if (pId != that.pId) return false;
        if (pDate != null ? !pDate.equals(that.pDate) : that.pDate != null) return false;
        if (pUserid != null ? !pUserid.equals(that.pUserid) : that.pUserid != null) return false;
        if (pIden != null ? !pIden.equals(that.pIden) : that.pIden != null) return false;
        if (pTitle != null ? !pTitle.equals(that.pTitle) : that.pTitle != null) return false;
        if (pContrent != null ? !pContrent.equals(that.pContrent) : that.pContrent != null) return false;
        if (pStu != null ? !pStu.equals(that.pStu) : that.pStu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pId;
        result = 31 * result + (pDate != null ? pDate.hashCode() : 0);
        result = 31 * result + (pUserid != null ? pUserid.hashCode() : 0);
        result = 31 * result + (pIden != null ? pIden.hashCode() : 0);
        result = 31 * result + (pTitle != null ? pTitle.hashCode() : 0);
        result = 31 * result + (pContrent != null ? pContrent.hashCode() : 0);
        result = 31 * result + (pStu != null ? pStu.hashCode() : 0);
        return result;
    }
}
