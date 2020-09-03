package com.meitu.search.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.HotkeyConfig;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.exception.OptException;
import com.meitu.search.mapper.HotkeyConfigMapper;
import com.meitu.search.service.IHotkeyConfigService;
import com.meitu.search.util.StringUtil;
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
    public PageInfo<HotkeyConfig> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HotkeyConfig> hotkeyConfigs = hotkeyConfigMapper.selectAll();
        PageInfo<HotkeyConfig> hotkeyConfigPageInfo = new PageInfo<>(hotkeyConfigs);
        return hotkeyConfigPageInfo;
    }

    @Override
    public List<HotkeyConfig> selectRankList(int limit) {
        final int allowMaxOrder = 10;
        limit = Math.min(limit, allowMaxOrder);
        Date now = new Date();
        return hotkeyConfigMapper.selectListByAllow(now, limit);
    }

    @Override
    public HotkeyConfig selectOneByKey(String key) {
        if (StringUtil.isEmpty(key)) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        HotkeyConfig config = hotkeyConfigMapper.selectOneByKey(key);
        return config;
    }

    @Override
    public boolean insert(HotkeyConfig hotkeyConfig) {
        if (Objects.isNull(hotkeyConfig)) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        Date now = new Date();
        hotkeyConfig.setCreateDate(now);
        hotkeyConfig.setUpdateDate(now);
        boolean insert = hotkeyConfigMapper.insert(hotkeyConfig);
        return insert;
    }

    @Override
    public boolean update(HotkeyConfig hotkeyConfig) {
        if (Objects.isNull(hotkeyConfig)) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        Date now = new Date();
        hotkeyConfig.setUpdateDate(now);
        return hotkeyConfigMapper.update(hotkeyConfig);
    }

    @Override
    public boolean delete(int id) {
        if (id <= 0) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        return hotkeyConfigMapper.delete(id);
    }
}
