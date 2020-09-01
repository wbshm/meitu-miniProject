package com.meitu.search.service;

import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.HotkeyConfig;

import java.util.List;

/**
 * @InterfaceName ISearchConfigService
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 20:24
 */
public interface IHotkeyConfigService {

    /**
     * 获取所有的后台配置信息
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageInfo<HotkeyConfig> getAll(int pageSize, int pageNum);

    /**
     * 获取关键词排行
     *
     * @return
     */
    List<HotkeyConfig> getRankList(int limit);

    /**
     * 新增一条数据
     *
     * @param hotkeyConfig
     * @return
     */
    boolean insert(HotkeyConfig hotkeyConfig);

    /**
     * 更新一条数据
     *
     * @param hotkeyConfig
     * @return
     */
    boolean update(HotkeyConfig hotkeyConfig);

    /**
     * 根据ID删除数据
     *
     * @param id
     * @return
     */
    boolean delete(int id);
}
