package com.entity;

import javax.persistence.*;

/**
 * Created by 10922 on 2017/12/30.
 */
@Entity
@Table(name = "dxcriteria1", schema = "museum_assess", catalog = "")
public class Dxcriteria1Entity {
    private int dxc1Id;
    private String dxc1Name;

    @Id
    @Column(name = "dxc1id")
    public int getDxc1Id() {
        return dxc1Id;
    }

    public void setDxc1Id(int dxc1Id) {
        this.dxc1Id = dxc1Id;
    }

    @Basic
    @Column(name = "dxc1name")
    public String getDxc1Name() {
        return dxc1Name;
    }

    public void setDxc1Name(String dxc1Name) {
        this.dxc1Name = dxc1Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dxcriteria1Entity that = (Dxcriteria1Entity) o;

        if (dxc1Id != that.dxc1Id) return false;
        if (dxc1Name != null ? !dxc1Name.equals(that.dxc1Name) : that.dxc1Name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dxc1Id;
        result = 31 * result + (dxc1Name != null ? dxc1Name.hashCode() : 0);
        return result;
    }
}
