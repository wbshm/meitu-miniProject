package com.meitu.search.service;

import com.meitu.search.bean.SearchHistory;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ISearchHistory
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 8:26
 */
public interface ISearchHistoryService {


    /**
     * 计算某一个时刻之后，关键字的搜索次数。
     *
     * @param date  Date 搜索范围为该日期至今
     * @param limit int 限制搜索的条数
     * @return SearchHistory List
     */
    List<SearchHistory> countHistory(Date date, int limit);

    /**
     * 记录查询的关键字
     *
     * @param history SearchHistory
     * @return boolean
     */
    boolean insert(SearchHistory history);
}
