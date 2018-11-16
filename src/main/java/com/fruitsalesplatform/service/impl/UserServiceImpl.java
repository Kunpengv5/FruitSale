package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.UserEntity;
import com.fruitsalesplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author dukunpeng
 * @date 2018/11/15 19:46
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity get(Serializable id) {
        return userDao.get(id);
    }

    @Override
    public List<UserEntity> find(Map map) {
        return userDao.find(map);
    }

    @Override
    public void insert(UserEntity userEntity) {
        userDao.insert(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        userDao.update(userEntity);
    }

    @Override
    public void deleteByUserId(Serializable id) {
        userDao.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        userDao.delete(ids);
    }
}
