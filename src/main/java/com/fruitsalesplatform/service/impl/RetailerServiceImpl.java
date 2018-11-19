package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.RetailerEntity;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class RetailerServiceImpl implements RetailerService {

    @Autowired
    RetailerDao retailerDao;

    @Override
    public RetailerEntity get(Serializable retailerId) {
        return retailerDao.get(retailerId);
    }

    @Override
    public List<RetailerEntity> find(Map map) {
        return retailerDao.find(map);
    }

    @Override
    public void insert(RetailerEntity retailerEntity) {
        retailerDao.insert(retailerEntity);
    }

    @Override
    public void update(RetailerEntity retailerEntity) {
        retailerDao.update(retailerEntity);
    }

    @Override
    public void deleteById(Serializable retailerId) {
        retailerDao.deleteById(retailerId);
    }

    @Override
    public void delete(Serializable[] ids) {
        retailerDao.delete(ids);
    }

    @Override
    public int count(Map map) {
        return retailerDao.count(map);
    }
}
