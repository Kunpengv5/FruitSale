package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.UserEntity;

import java.util.List;

/**
 * @author dukunpeng
 * @date 2018/11/13 20:54
 */
public interface TestService {
    List<UserEntity> get(UserEntity user);
}
