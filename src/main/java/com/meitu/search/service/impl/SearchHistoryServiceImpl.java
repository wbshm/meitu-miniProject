package com.meitu.search.service.impl;

import com.meitu.search.bean.SearchHistory;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.exception.OptException;
import com.meitu.search.mapper.SearchHistoryMapper;
import com.meitu.search.service.ISearchHistoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName SearchHistoryServiceImpl
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 8:30
 */
@Service
public class SearchHistoryServiceImpl implements ISearchHistoryService {
    private final SearchHistoryMapper searchHistoryMapper;

    public SearchHistoryServiceImpl(SearchHistoryMapper searchHistoryMapper) {
        this.searchHistoryMapper = searchHistoryMapper;
    }

    /**
     * todo: 写缓存
     *
     * @param date  Date 搜索范围为该日期至今
     * @param limit int 限制搜索的条数
     * @return SearchHistory List
     */
    @Override
    public List<SearchHistory> countHistory(Date date, int limit) {
        Date now = new Date();
        if (limit <= 0 || Objects.isNull(date) || now.before(date)) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        return searchHistoryMapper.countNumListByDate(date, limit);
    }

    @Override
    public boolean insert(SearchHistory history) {
        if (Objects.isNull(history)) {
            throw new OptException(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        Date now = new Date();
        history.setCreateDate(now);
        return searchHistoryMapper.insert(history);
    }
}
