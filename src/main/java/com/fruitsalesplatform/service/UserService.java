package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author dukunpeng
 * @date 2018/11/15 19:44
 */

public interface UserService {
    UserEntity get(Serializable id);
    List<UserEntity> find(Map map);
    void insert(UserEntity userEntity);
    void update(UserEntity userEntity);
    void deleteByUserId(Serializable id);
    void delete(Serializable []ids);
}
