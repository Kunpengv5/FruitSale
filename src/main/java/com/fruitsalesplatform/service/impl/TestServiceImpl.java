package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.dao.TestDao;
import com.fruitsalesplatform.entity.UserEntity;
import com.fruitsalesplatform.service.TestService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dukunpeng
 * @date 2018/11/13 20:57
 */
@Service
public class TestServiceImpl implements TestService {

    private static Logger logger =LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    TestDao testDao;

    @Override
    public List<UserEntity> get(UserEntity user) {
        List<UserEntity> usersList = null;
        if (user==null||StringUtils.isBlank(user.getName())){
            System.out.println("测试");
            usersList = testDao.selectAll();
        }else {
            usersList = testDao.selectUserByName(user);
        }
        return usersList;
    }
}
