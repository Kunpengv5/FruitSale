package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.BaseDao;
import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.UserEntity;

/**
 * @author dukunpeng
 * @date 2018/11/15 17:50
 */
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao{
    public UserDaoImpl(){
        super.setNamespace("com.fruitsalesplatform.mapper.UserMapper");
    }
}
