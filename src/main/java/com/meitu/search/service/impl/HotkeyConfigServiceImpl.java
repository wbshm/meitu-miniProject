package com.meitu.search.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.HotkeyConfig;
import com.meitu.search.mapper.HotkeyConfigMapper;
import com.meitu.search.service.IHotkeyConfigService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName SearchConfigServiceImpl
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 20:24
 */
@Service
public class HotkeyConfigServiceImpl implements IHotkeyConfigService {
    private final HotkeyConfigMapper hotkeyConfigMapper;

    public HotkeyConfigServiceImpl(HotkeyConfigMapper hotkeyConfigMapper) {
        this.hotkeyConfigMapper = hotkeyConfigMapper;
    }

    @Override
    public PageInfo<HotkeyConfig> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HotkeyConfig> hotkeyConfigs = hotkeyConfigMapper.selectAll();
        return new PageInfo<>(hotkeyConfigs);
    }

    @Override
    public List<HotkeyConfig> getRankList(int limit) {
        final int allowMaxOrder = 10;
        limit = Math.min(limit, allowMaxOrder);
        Date now = new Date();
        return hotkeyConfigMapper.selectListByAllow(now, limit);
    }

    @Override
    public boolean insert(HotkeyConfig hotkeyConfig) {
        if (Objects.isNull(hotkeyConfig)) {

        }
        boolean insert = hotkeyConfigMapper.insert(hotkeyConfig);
        return insert;
    }

    @Override
    public boolean update(HotkeyConfig hotkeyConfig) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
