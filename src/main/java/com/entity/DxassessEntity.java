package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 10922 on 2017/12/30.
 */
@Entity
@Table(name = "dxassess", schema = "museum_assess", catalog = "")
public class DxassessEntity {
    private int dxaid;
    private int year;
    private Double dxscore1;
    private Double dxscore2;
    private Double dxscore3;
    private Double dxscore4;
    private Double dxscore5;
    private Double dxscore11;
    private Double dxscore12;
    private Double dxscore13;
    private Double dxscore21;
    private Double dxscore22;
    private Double dxscore31;
    private Double dxscore32;
    private Double dxscore33;
    private Double dxscore34;
    private Double dxscore41;
    private Double dxscore42;
    private Double dxscore43;
    private Double dxscore51;
    private Double dxscore52;
    private Double dxscore53;
    private Double dxtotal;

    @Basic
    @Column(name = "dxaid")
    public int getDxaid() {
        return dxaid;
    }

    public void setDxaid(int dxaid) {
        this.dxaid = dxaid;
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
    @Column(name = "dxscore1")
    public Double getDxscore1() {
        return dxscore1;
    }

    public void setDxscore1(Double dxscore1) {
        this.dxscore1 = dxscore1;
    }

    @Basic
    @Column(name = "dxscore2")
    public Double getDxscore2() {
        return dxscore2;
    }

    public void setDxscore2(Double dxscore2) {
        this.dxscore2 = dxscore2;
    }

    @Basic
    @Column(name = "dxscore3")
    public Double getDxscore3() {
        return dxscore3;
    }

    public void setDxscore3(Double dxscore3) {
        this.dxscore3 = dxscore3;
    }

    @Basic
    @Column(name = "dxscore4")
    public Double getDxscore4() {
        return dxscore4;
    }

    public void setDxscore4(Double dxscore4) {
        this.dxscore4 = dxscore4;
    }

    @Basic
    @Column(name = "dxscore5")
    public Double getDxscore5() {
        return dxscore5;
    }

    public void setDxscore5(Double dxscore5) {
        this.dxscore5 = dxscore5;
    }

    @Basic
    @Column(name = "dxscore11")
    public Double getDxscore11() {
        return dxscore11;
    }

    public void setDxscore11(Double dxscore11) {
        this.dxscore11 = dxscore11;
    }

    @Basic
    @Column(name = "dxscore12")
    public Double getDxscore12() {
        return dxscore12;
    }

    public void setDxscore12(Double dxscore12) {
        this.dxscore12 = dxscore12;
    }

    @Basic
    @Column(name = "dxscore13")
    public Double getDxscore13() {
        return dxscore13;
    }

    public void setDxscore13(Double dxscore13) {
        this.dxscore13 = dxscore13;
    }

    @Basic
    @Column(name = "dxscore21")
    public Double getDxscore21() {
        return dxscore21;
    }

    public void setDxscore21(Double dxscore21) {
        this.dxscore21 = dxscore21;
    }

    @Basic
    @Column(name = "dxscore22")
    public Double getDxscore22() {
        return dxscore22;
    }

    public void setDxscore22(Double dxscore22) {
        this.dxscore22 = dxscore22;
    }

    @Basic
    @Column(name = "dxscore31")
    public Double getDxscore31() {
        return dxscore31;
    }

    public void setDxscore31(Double dxscore31) {
        this.dxscore31 = dxscore31;
    }

    @Basic
    @Column(name = "dxscore32")
    public Double getDxscore32() {
        return dxscore32;
    }

    public void setDxscore32(Double dxscore32) {
        this.dxscore32 = dxscore32;
    }

    @Basic
    @Column(name = "dxscore33")
    public Double getDxscore33() {
        return dxscore33;
    }

    public void setDxscore33(Double dxscore33) {
        this.dxscore33 = dxscore33;
    }

    @Basic
    @Column(name = "dxscore34")
    public Double getDxscore34() {
        return dxscore34;
    }

    public void setDxscore34(Double dxscore34) {
        this.dxscore34 = dxscore34;
    }

    @Basic
    @Column(name = "dxscore41")
    public Double getDxscore41() {
        return dxscore41;
    }

    public void setDxscore41(Double dxscore41) {
        this.dxscore41 = dxscore41;
    }

    @Basic
    @Column(name = "dxscore42")
    public Double getDxscore42() {
        return dxscore42;
    }

    public void setDxscore42(Double dxscore42) {
        this.dxscore42 = dxscore42;
    }

    @Basic
    @Column(name = "dxscore43")
    public Double getDxscore43() {
        return dxscore43;
    }

    public void setDxscore43(Double dxscore43) {
        this.dxscore43 = dxscore43;
    }

    @Basic
    @Column(name = "dxscore51")
    public Double getDxscore51() {
        return dxscore51;
    }

    public void setDxscore51(Double dxscore51) {
        this.dxscore51 = dxscore51;
    }

    @Basic
    @Column(name = "dxscore52")
    public Double getDxscore52() {
        return dxscore52;
    }

    public void setDxscore52(Double dxscore52) {
        this.dxscore52 = dxscore52;
    }

    @Basic
    @Column(name = "dxscore53")
    public Double getDxscore53() {
        return dxscore53;
    }

    public void setDxscore53(Double dxscore53) {
        this.dxscore53 = dxscore53;
    }

    @Basic
    @Column(name = "dxtotal")
    public Double getDxtotal() {
        return dxtotal;
    }

    public void setDxtotal(Double dxtotal) {
        this.dxtotal = dxtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DxassessEntity that = (DxassessEntity) o;

        if (dxaid != that.dxaid) return false;
        if (year != that.year) return false;
        if (dxscore1 != null ? !dxscore1.equals(that.dxscore1) : that.dxscore1 != null) return false;
        if (dxscore2 != null ? !dxscore2.equals(that.dxscore2) : that.dxscore2 != null) return false;
        if (dxscore3 != null ? !dxscore3.equals(that.dxscore3) : that.dxscore3 != null) return false;
        if (dxscore4 != null ? !dxscore4.equals(that.dxscore4) : that.dxscore4 != null) return false;
        if (dxscore5 != null ? !dxscore5.equals(that.dxscore5) : that.dxscore5 != null) return false;
        if (dxscore11 != null ? !dxscore11.equals(that.dxscore11) : that.dxscore11 != null) return false;
        if (dxscore12 != null ? !dxscore12.equals(that.dxscore12) : that.dxscore12 != null) return false;
        if (dxscore13 != null ? !dxscore13.equals(that.dxscore13) : that.dxscore13 != null) return false;
        if (dxscore21 != null ? !dxscore21.equals(that.dxscore21) : that.dxscore21 != null) return false;
        if (dxscore22 != null ? !dxscore22.equals(that.dxscore22) : that.dxscore22 != null) return false;
        if (dxscore31 != null ? !dxscore31.equals(that.dxscore31) : that.dxscore31 != null) return false;
        if (dxscore32 != null ? !dxscore32.equals(that.dxscore32) : that.dxscore32 != null) return false;
        if (dxscore33 != null ? !dxscore33.equals(that.dxscore33) : that.dxscore33 != null) return false;
        if (dxscore34 != null ? !dxscore34.equals(that.dxscore34) : that.dxscore34 != null) return false;
        if (dxscore41 != null ? !dxscore41.equals(that.dxscore41) : that.dxscore41 != null) return false;
        if (dxscore42 != null ? !dxscore42.equals(that.dxscore42) : that.dxscore42 != null) return false;
        if (dxscore43 != null ? !dxscore43.equals(that.dxscore43) : that.dxscore43 != null) return false;
        if (dxscore51 != null ? !dxscore51.equals(that.dxscore51) : that.dxscore51 != null) return false;
        if (dxscore52 != null ? !dxscore52.equals(that.dxscore52) : that.dxscore52 != null) return false;
        if (dxscore53 != null ? !dxscore53.equals(that.dxscore53) : that.dxscore53 != null) return false;
        if (dxtotal != null ? !dxtotal.equals(that.dxtotal) : that.dxtotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dxaid;
        result = 31 * result + year;
        result = 31 * result + (dxscore1 != null ? dxscore1.hashCode() : 0);
        result = 31 * result + (dxscore2 != null ? dxscore2.hashCode() : 0);
        result = 31 * result + (dxscore3 != null ? dxscore3.hashCode() : 0);
        result = 31 * result + (dxscore4 != null ? dxscore4.hashCode() : 0);
        result = 31 * result + (dxscore5 != null ? dxscore5.hashCode() : 0);
        result = 31 * result + (dxscore11 != null ? dxscore11.hashCode() : 0);
        result = 31 * result + (dxscore12 != null ? dxscore12.hashCode() : 0);
        result = 31 * result + (dxscore13 != null ? dxscore13.hashCode() : 0);
        result = 31 * result + (dxscore21 != null ? dxscore21.hashCode() : 0);
        result = 31 * result + (dxscore22 != null ? dxscore22.hashCode() : 0);
        result = 31 * result + (dxscore31 != null ? dxscore31.hashCode() : 0);
        result = 31 * result + (dxscore32 != null ? dxscore32.hashCode() : 0);
        result = 31 * result + (dxscore33 != null ? dxscore33.hashCode() : 0);
        result = 31 * result + (dxscore34 != null ? dxscore34.hashCode() : 0);
        result = 31 * result + (dxscore41 != null ? dxscore41.hashCode() : 0);
        result = 31 * result + (dxscore42 != null ? dxscore42.hashCode() : 0);
        result = 31 * result + (dxscore43 != null ? dxscore43.hashCode() : 0);
        result = 31 * result + (dxscore51 != null ? dxscore51.hashCode() : 0);
        result = 31 * result + (dxscore52 != null ? dxscore52.hashCode() : 0);
        result = 31 * result + (dxscore53 != null ? dxscore53.hashCode() : 0);
        result = 31 * result + (dxtotal != null ? dxtotal.hashCode() : 0);
        return result;
    }
}
