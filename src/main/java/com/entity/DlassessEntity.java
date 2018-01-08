package com.entity;

import javax.persistence.*;

/**
 * Created by 10922 on 2017/12/30.
 */
@Entity
@Table(name = "dlassess", schema = "museum_assess")
public class DlassessEntity {
    private int dlaid;
    private int mid;
    private int year;
    private Double dlscore1;
    private Double dlscore2;
    private Double dlscore3;
    private Double dlscore4;
    private Double dlscore11;
    private Double dlscore12;
    private Double dlscore21;
    private Double dlscore22;
    private Double dlscore23;
    private Double dlscore31;
    private Double dlscore32;
    private Double dlscore41;
    private Double dlscore42;
    private Double dltotal;

    public DlassessEntity(){
    }

    @Id
    @Column(name = "dlaid")
    public int getDlaid() {
        return dlaid;
    }

    public void setDlaid(int dlaid) {
        this.dlaid = dlaid;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "dlscore1")
    public Double getDlscore1() {
        return dlscore1;
    }

    public void setDlscore1(Double dlscore1) {
        this.dlscore1 = dlscore1;
    }

    @Basic
    @Column(name = "dlscore2")
    public Double getDlscore2() {
        return dlscore2;
    }

    public void setDlscore2(Double dlscore2) {
        this.dlscore2 = dlscore2;
    }

    @Basic
    @Column(name = "dlscore3")
    public Double getDlscore3() {
        return dlscore3;
    }

    public void setDlscore3(Double dlscore3) {
        this.dlscore3 = dlscore3;
    }

    @Basic
    @Column(name = "dlscore4")
    public Double getDlscore4() {
        return dlscore4;
    }

    public void setDlscore4(Double dlscore4) {
        this.dlscore4 = dlscore4;
    }

    @Basic
    @Column(name = "dlscore11")
    public Double getDlscore11() {
        return dlscore11;
    }

    public void setDlscore11(Double dlscore11) {
        this.dlscore11 = dlscore11;
    }

    @Basic
    @Column(name = "dlscore12")
    public Double getDlscore12() {
        return dlscore12;
    }

    public void setDlscore12(Double dlscore12) {
        this.dlscore12 = dlscore12;
    }

    @Basic
    @Column(name = "dlscore21")
    public Double getDlscore21() {
        return dlscore21;
    }

    public void setDlscore21(Double dlscore21) {
        this.dlscore21 = dlscore21;
    }

    @Basic
    @Column(name = "dlscore22")
    public Double getDlscore22() {
        return dlscore22;
    }

    public void setDlscore22(Double dlscore22) {
        this.dlscore22 = dlscore22;
    }

    @Basic
    @Column(name = "dlscore23")
    public Double getDlscore23() {
        return dlscore23;
    }

    public void setDlscore23(Double dlscore23) {
        this.dlscore23 = dlscore23;
    }

    @Basic
    @Column(name = "dlscore31")
    public Double getDlscore31() {
        return dlscore31;
    }

    public void setDlscore31(Double dlscore31) {
        this.dlscore31 = dlscore31;
    }

    @Basic
    @Column(name = "dlscore32")
    public Double getDlscore32() {
        return dlscore32;
    }

    public void setDlscore32(Double dlscore32) {
        this.dlscore32 = dlscore32;
    }

    @Basic
    @Column(name = "dlscore41")
    public Double getDlscore41() {
        return dlscore41;
    }

    public void setDlscore41(Double dlscore41) {
        this.dlscore41 = dlscore41;
    }

    @Basic
    @Column(name = "dlscore42")
    public Double getDlscore42() {
        return dlscore42;
    }

    public void setDlscore42(Double dlscore42) {
        this.dlscore42 = dlscore42;
    }

    @Basic
    @Column(name = "dltotal")
    public Double getDltotal() {
        return dltotal;
    }

    public void setDltotal(Double dltotal) {
        this.dltotal = dltotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DlassessEntity that = (DlassessEntity) o;

        if (dlaid != that.dlaid) return false;
        if (year != that.year) return false;
        if (dlscore1 != null ? !dlscore1.equals(that.dlscore1) : that.dlscore1 != null) return false;
        if (dlscore2 != null ? !dlscore2.equals(that.dlscore2) : that.dlscore2 != null) return false;
        if (dlscore3 != null ? !dlscore3.equals(that.dlscore3) : that.dlscore3 != null) return false;
        if (dlscore4 != null ? !dlscore4.equals(that.dlscore4) : that.dlscore4 != null) return false;
        if (dlscore11 != null ? !dlscore11.equals(that.dlscore11) : that.dlscore11 != null) return false;
        if (dlscore12 != null ? !dlscore12.equals(that.dlscore12) : that.dlscore12 != null) return false;
        if (dlscore21 != null ? !dlscore21.equals(that.dlscore21) : that.dlscore21 != null) return false;
        if (dlscore22 != null ? !dlscore22.equals(that.dlscore22) : that.dlscore22 != null) return false;
        if (dlscore23 != null ? !dlscore23.equals(that.dlscore23) : that.dlscore23 != null) return false;
        if (dlscore31 != null ? !dlscore31.equals(that.dlscore31) : that.dlscore31 != null) return false;
        if (dlscore32 != null ? !dlscore32.equals(that.dlscore32) : that.dlscore32 != null) return false;
        if (dlscore41 != null ? !dlscore41.equals(that.dlscore41) : that.dlscore41 != null) return false;
        if (dlscore42 != null ? !dlscore42.equals(that.dlscore42) : that.dlscore42 != null) return false;
        if (dltotal != null ? !dltotal.equals(that.dltotal) : that.dltotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dlaid;
        result = 31 * result + year;
        result = 31 * result + (dlscore1 != null ? dlscore1.hashCode() : 0);
        result = 31 * result + (dlscore2 != null ? dlscore2.hashCode() : 0);
        result = 31 * result + (dlscore3 != null ? dlscore3.hashCode() : 0);
        result = 31 * result + (dlscore4 != null ? dlscore4.hashCode() : 0);
        result = 31 * result + (dlscore11 != null ? dlscore11.hashCode() : 0);
        result = 31 * result + (dlscore12 != null ? dlscore12.hashCode() : 0);
        result = 31 * result + (dlscore21 != null ? dlscore21.hashCode() : 0);
        result = 31 * result + (dlscore22 != null ? dlscore22.hashCode() : 0);
        result = 31 * result + (dlscore23 != null ? dlscore23.hashCode() : 0);
        result = 31 * result + (dlscore31 != null ? dlscore31.hashCode() : 0);
        result = 31 * result + (dlscore32 != null ? dlscore32.hashCode() : 0);
        result = 31 * result + (dlscore41 != null ? dlscore41.hashCode() : 0);
        result = 31 * result + (dlscore42 != null ? dlscore42.hashCode() : 0);
        result = 31 * result + (dltotal != null ? dltotal.hashCode() : 0);
        return result;
    }
    public int getMid(){
        return mid;
    }
    public void setMid(int mid){
        this.mid=mid;
    }

}
