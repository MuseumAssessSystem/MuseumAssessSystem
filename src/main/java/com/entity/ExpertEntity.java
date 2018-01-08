package com.entity;

import javax.persistence.*;

/**
 * Created by 10922 on 2017/12/30.
 */
@Entity
@Table(name = "expert", schema = "museum_assess")
public class ExpertEntity {
    private int eid;
    private String ename;
    private String description;
    private int dxc1id;

    public ExpertEntity(){

    }

    public ExpertEntity(int eid) { this.eid = eid;
    }

    @Id
    @Column(name = "eid")
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "ename")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpertEntity that = (ExpertEntity) o;

        if (eid != that.eid) return false;
        if (ename != null ? !ename.equals(that.ename) : that.ename != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public int getDxc1id(){
        return dxc1id;
    }
    public void setDxc1id(int dxc1id){ this.dxc1id = dxc1id;}

}
