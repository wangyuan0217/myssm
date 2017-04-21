package com.trump.service;

import java.util.List;


public interface BaseService<T> {

    /**
     * 添加某个对象
     *
     * @param t 待添加的对象
     */
    void add(T t) throws Exception;

    /**
     * 删除某个对象，在企业开发中，我们一般不做物理删除，只是添加某个字段对其数据进行可用控制
     *
     * @param t 待删除对象
     */
    void del(T t) throws Exception;

    /**
     * 更新某个对象
     *
     * @param t 待更新对象
     */
    void update(T t) throws Exception;

    /**
     * 通过ID查找一个对象
     *
     * @param Id 待查询的对象的ID
     * @return 返回该ID对应的对象
     */
    T findOneById(String Id) throws Exception;

    /**
     * 查找对象集合
     *
     * @return 返回对象集合
     */
    List<T> findAll() throws Exception;

}
