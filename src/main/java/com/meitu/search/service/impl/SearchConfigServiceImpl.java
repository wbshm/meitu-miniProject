package com.meitu.search.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.SearchConfig;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.exception.OptException;
import com.meitu.search.mapper.SearchConfigMapper;
import com.meitu.search.service.ISearchConfigService;
import com.meitu.search.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName SearchConfigServiceImpl
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 8:55
 */
@Service
public class SearchConfigServiceImpl implements ISearchConfigService {
    private final SearchConfigMapper searchConfigMapper;

    public SearchConfigServiceImpl(SearchConfigMapper searchConfigMapper) {
        this.searchConfigMapper = searchConfigMapper;
    }

    @Override
    public PageInfo<SearchConfig> selectAll(int pageNum, int pageSize) {
        if (pageNum < 0 || pageSize <= 0) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SearchConfig> searchConfigs = searchConfigMapper.selectAll();
        return new PageInfo<>(searchConfigs);
    }

    @Override
    public SearchConfig selectOneByKey(String key) {
        if (StringUtil.isEmpty(key)) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        return searchConfigMapper.selectOneByKey(key);
    }

    @Override
    public boolean insert(SearchConfig config) {
        if (Objects.isNull(config) || StringUtil.isEmpty(config.getConfigKey())) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        return searchConfigMapper.insert(config);
    }

    @Override
    public boolean update(SearchConfig config) {
        if (Objects.isNull(config) || config.getId() <= 0 || StringUtil.isEmpty(config.getConfigKey())) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        return searchConfigMapper.update(config);
    }

    @Override
    public boolean delete(int id) {
        if (id <= 0) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        return searchConfigMapper.delete(id);
    }
}
