package com.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author dukunpeng
 * @date 2018/11/15 14:28
 * @doc 泛型类，基础的DAO接口，提供统一的增删改查功能
 */
public interface BaseDao<T> {
    T get(Serializable id);//只查询一个数据，常用于修改 （这块有疑问）
    List<T> find(Map map);//根据条件查询多个结果
    void insert(T entity);//插入，使用实体作为参数
    void update(T entity);//更新，使用实体作为参数
    void deleteById(Serializable id);//按id删除，删除一条；支持整形和字符串类型id
    void delete(Serializable[] ids);//批量删除
}
