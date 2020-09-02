package com.meitu.search.service;

import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.SearchConfig;

/**
 * @ClassName ISearchConfigService
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 8:26
 */
public interface ISearchConfigService {

    /**
     * 查询后台配置信息
     *
     * @param pageNum  页码
     * @param pageSize 单页大小
     * @return
     */
    PageInfo<SearchConfig> selectAll(int pageNum, int pageSize);

    /**
     * 根据Key来查询对应的配置信息
     *
     * @param key 查询的key
     * @return
     */
    SearchConfig selectOneByKey(String key);

    /**
     * 新增一条配置
     *
     * @param config 新增的配置信息
     * @return
     */
    boolean insert(SearchConfig config);

    /**
     * 根据ID更新配置信息
     *
     * @param config 需要更新的配置，且ID值不为null
     * @return
     */
    boolean update(SearchConfig config);

    /**
     * 根据ID删除配置
     *
     * @param id 删除配置的ID
     * @return
     */
    boolean delete(int id);
}
