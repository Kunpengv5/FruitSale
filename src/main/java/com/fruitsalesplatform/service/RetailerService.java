package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.RetailerEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface RetailerService {
    RetailerEntity get(Serializable retailerId);
    List<RetailerEntity> find(Map map);
    void insert(RetailerEntity retailerEntity);
    void update(RetailerEntity retailerEntity);
    void deleteById(Serializable retailerId);
    void delete(Serializable [] ids);
    int count(Map map);
}
