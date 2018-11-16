package com.fruitsalesplatform.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author dukunpeng
 * @date 2018/11/9 14:31
 */
@Entity
@Table(name = "accessory", schema = "fruit_manage", catalog = "")
public class AccessoryEntity {
    private String accessoryid;
    private String fruitid;
    private String name;
    private Double price;
    private Timestamp createtime;

    @Id
    @Column(name = "accessoryid")
    public String getAccessoryid() {
        return accessoryid;
    }

    public void setAccessoryid(String accessoryid) {
        this.accessoryid = accessoryid;
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

        AccessoryEntity that = (AccessoryEntity) o;

        if (accessoryid != null ? !accessoryid.equals(that.accessoryid) : that.accessoryid != null) return false;
        if (fruitid != null ? !fruitid.equals(that.fruitid) : that.fruitid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accessoryid != null ? accessoryid.hashCode() : 0;
        result = 31 * result + (fruitid != null ? fruitid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
