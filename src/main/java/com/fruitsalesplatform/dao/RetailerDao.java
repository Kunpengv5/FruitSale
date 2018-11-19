package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.RetailerEntity;

import java.util.Map;

public interface RetailerDao extends BaseDao<RetailerEntity> {

    //计算总数
    int count(Map map);
}
