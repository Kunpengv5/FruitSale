package com.fruitsalesplatform.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author dukunpeng
 * @date 2018/11/9 14:31
 */
@Entity
@Table(name = "commodities", schema = "fruit_manage", catalog = "")
public class CommoditiesEntity {
    private String fruitid;
    private String name;
    private Double price;
    private String locality;
    private Timestamp createtime;

    @Id
    @Column(name = "fruitid")
    public String getFruitid() {
        return fruitid;
    }

    public void setFruitid(String fruitid) {
        this.fruitid = fruitid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "locality")
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
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

        CommoditiesEntity that = (CommoditiesEntity) o;

        if (fruitid != null ? !fruitid.equals(that.fruitid) : that.fruitid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (locality != null ? !locality.equals(that.locality) : that.locality != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fruitid != null ? fruitid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
