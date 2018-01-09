package com.entity;

import javax.persistence.*;

/**
 * Created by 10922 on 2017/12/30.
 */
@Entity
@Table(name = "museum", schema = "museum_assess")
public class MuseumEntity {
    private String mname;
    private String mtype;
    private String mclass;
    private String description;
    private int mid;

    public MuseumEntity(){
    }
    public MuseumEntity(int mid){
         this.mid=mid;
    }

    @Basic
    @Column(name = "mname")
    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Basic
    @Column(name = "mtype")
    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    @Basic
    @Column(name = "mclass")
    public String getMclass() {
        return mclass;
    }

    public void setMclass(String mclass) {
        this.mclass = mclass;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "mid")
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MuseumEntity that = (MuseumEntity) o;

        if (mid != that.mid) return false;
        if (mname != null ? !mname.equals(that.mname) : that.mname != null) return false;
        if (mtype != null ? !mtype.equals(that.mtype) : that.mtype != null) return false;
        if (mclass != null ? !mclass.equals(that.mclass) : that.mclass != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mname != null ? mname.hashCode() : 0;
        result = 31 * result + (mtype != null ? mtype.hashCode() : 0);
        result = 31 * result + (mclass != null ? mclass.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + mid;
        return result;
    }
}
