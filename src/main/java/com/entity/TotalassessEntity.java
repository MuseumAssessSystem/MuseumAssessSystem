package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 10922 on 2017/12/30.
 */
@Entity
@Table(name = "totalassess", schema = "museum_assess")
public class TotalassessEntity {
    private Integer taid;
    private Double tscore;
    private Integer mid;
    private Integer year;

    @Basic
    @Column(name = "taid")
    public Integer getTaid() {
        return taid;
    }

    public void setTaid(Integer taid) {
        this.taid = taid;
    }

    @Basic
    @Column(name = "tscore")
    public Double getTscore() {
        return tscore;
    }

    public void setTscore(Double tscore) {
        this.tscore = tscore;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TotalassessEntity that = (TotalassessEntity) o;

        if (taid != null ? !taid.equals(that.taid) : that.taid != null) return false;
        if (tscore != null ? !tscore.equals(that.tscore) : that.tscore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taid != null ? taid.hashCode() : 0;
        result = 31 * result + (tscore != null ? tscore.hashCode() : 0);
        return result;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}
