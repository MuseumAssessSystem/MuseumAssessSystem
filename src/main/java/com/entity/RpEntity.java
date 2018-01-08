package com.entity;

import javax.persistence.*;

/**
 * Created by 10922 on 2017/12/30.
 */
@Entity
@Table(name = "rp", schema = "museum_assess")
public class RpEntity {
    private int rid;
    private int pid;
    private int rpid;

    @Id
    @Column(name = "rpid")
    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }


}
