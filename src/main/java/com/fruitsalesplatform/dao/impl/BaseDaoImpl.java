package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author dukunpeng
 * @date 2018/11/15 14:35
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    private String namespace;


    @Override
    public T get(Serializable id) {
        return this.getSqlSession().selectOne(namespace+".get",id);
    }

    @Override
    public List<T> find(Map map) {
        List<T> oList = this.getSqlSession().selectList(namespace+".find",map);
        return oList;
    }

    @Override
    public void insert(Object entity) {
        this.getSqlSession().insert(namespace+".insert",entity);
    }

    @Override
    public void update(Object entity) {
        this.getSqlSession().update(namespace+".update",entity);
    }

    @Override
    public void deleteById(Serializable id) {
        this.getSqlSession().delete(namespace+".deleteById",id);
    }

    @Override
    public void delete(Serializable[] ids) {
        this.getSqlSession().delete(namespace+".delete",ids);
    }
}
