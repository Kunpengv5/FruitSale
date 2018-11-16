package com.fruitsalesplatform.entity;

import javax.persistence.*;

/**
 * @author dukunpeng
 * @date 2018/11/9 14:31
 */
@Entity
@Table(name = "middle_tab", schema = "fruit_manage", catalog = "")
public class MiddleTabEntity {
    private String middleid;
    private String contractid;
    private String fruitid;
    private Integer number;

    @Id
    @Column(name = "middleid")
    public String getMiddleid() {
        return middleid;
    }

    public void setMiddleid(String middleid) {
        this.middleid = middleid;
    }

    @Basic
    @Column(name = "contractid")
    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    @Basic
    @Column(name = "fruitid")
    public String getFruitid() {
        return fruitid;
    }

    public void setFruitid(String fruitid) {
        this.fruitid = fruitid;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiddleTabEntity that = (MiddleTabEntity) o;

        if (middleid != null ? !middleid.equals(that.middleid) : that.middleid != null) return false;
        if (contractid != null ? !contractid.equals(that.contractid) : that.contractid != null) return false;
        if (fruitid != null ? !fruitid.equals(that.fruitid) : that.fruitid != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = middleid != null ? middleid.hashCode() : 0;
        result = 31 * result + (contractid != null ? contractid.hashCode() : 0);
        result = 31 * result + (fruitid != null ? fruitid.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
