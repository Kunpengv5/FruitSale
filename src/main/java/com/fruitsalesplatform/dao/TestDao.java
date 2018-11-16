package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dukunpeng
 * @date 2018/11/13 20:30
 */
@Repository
public interface TestDao {
     List<UserEntity> selectUserByName(UserEntity userEntity);
     List<UserEntity> selectAll();

}
