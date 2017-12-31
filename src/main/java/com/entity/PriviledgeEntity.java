package com.entity;

import javax.persistence.*;

/**
 * Created by 10922 on 2017/12/30.
 */
@Entity
@Table(name = "priviledge", schema = "museum_assess", catalog = "")
public class PriviledgeEntity {
    private int pid;
    private String pname;

    @Id
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "pname")
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriviledgeEntity that = (PriviledgeEntity) o;

        if (pid != that.pid) return false;
        if (pname != null ? !pname.equals(that.pname) : that.pname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        return result;
    }
}
