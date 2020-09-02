package com.meitu.search.mapper;

import com.meitu.search.bean.SearchConfig;
import com.meitu.search.bean.SearchHistory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SearchConfigMapper
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 18:14
 */
@Component
public interface SearchHistoryMapper {


    /**
     * 根据Key查询配置
     *
     * @param date  Date
     * @param limit limit
     * @return SearchConfig
     */
    @Select("SELECT count(1) as count_num, search_key from search_history where " +
            "create_date>= #{date,jdbcType=TIMESTAMP} " +
            "group by search_key " +
            "limit #{limit,jdbcType=INTEGER}")
    @Results({
            @Result(property = "countNum", column = "count_num"),
            @Result(property = "searchKey", column = "search_key"),
            @Result(property = "createDate", column = "create_date"),
    })
    List<SearchHistory> countNumListByDate(Date date, int limit);

    /**
     * 插入数据
     *
     * @param history history
     * @return boolean
     */
    @Insert("insert into search_history (search_key, create_date)" +
            "values (#{searchKey,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP})")
    boolean insert(SearchHistory history);
}
