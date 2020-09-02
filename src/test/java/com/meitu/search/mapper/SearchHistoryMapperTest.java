package com.meitu.search.mapper;

import com.meitu.search.bean.SearchConfig;
import com.meitu.search.bean.SearchHistory;
import com.meitu.search.util.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchHistoryMapperTest {

    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Test
    void countNumListByDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, -24);
        Date time = calendar.getTime();
        List<SearchHistory> searchConfigs = searchHistoryMapper.countNumListByDate(time, 10);
        System.out.println(searchConfigs);
        assertTrue(searchConfigs.size() > 0);
    }

    @Test
    void insert() {
        SearchHistory searchHistory = newInstanceSearchHistory();
        boolean insert = searchHistoryMapper.insert(searchHistory);
        assertTrue(insert);
    }

    private SearchHistory newInstanceSearchHistory() {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setSearchKey("test");
        searchHistory.setCreateDate(new Date());
        return searchHistory;
    }
}
