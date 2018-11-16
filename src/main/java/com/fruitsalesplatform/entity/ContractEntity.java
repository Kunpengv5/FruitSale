package com.fruitsalesplatform.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author dukunpeng
 * @date 2018/11/9 14:31
 */
@Entity
@Table(name = "contract", schema = "fruit_manage", catalog = "")
public class ContractEntity {
    private String contractid;
    private String retailerid;
    private String barcode;
    private Integer type;
    private Timestamp createtime;

    @Id
    @Column(name = "contractid")
    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    @Basic
    @Column(name = "retailerid")
    public String getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(String retailerid) {
        this.retailerid = retailerid;
    }

    @Basic
    @Column(name = "barcode")
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractEntity that = (ContractEntity) o;

        if (contractid != null ? !contractid.equals(that.contractid) : that.contractid != null) return false;
        if (retailerid != null ? !retailerid.equals(that.retailerid) : that.retailerid != null) return false;
        if (barcode != null ? !barcode.equals(that.barcode) : that.barcode != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contractid != null ? contractid.hashCode() : 0;
        result = 31 * result + (retailerid != null ? retailerid.hashCode() : 0);
        result = 31 * result + (barcode != null ? barcode.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
