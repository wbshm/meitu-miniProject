package com.meitu.search.mapper;

import com.meitu.search.bean.SearchConfig;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName SearchConfigMapper
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 18:14
 */
@Component
public interface SearchConfigMapper {

    /**
     * 查询所有的配置信息
     *
     * @return SearchConfig List
     */
    @Select("SELECT id, config_key, config_value, config_title, create_date, update_date" +
            " FROM search_config")
    @Results({
            @Result(property = "searchKey", column = "search_key"),
            @Result(property = "keyStatus", column = "key_status"),
            @Result(property = "keyOrder", column = "key_order"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date"),
    })
    List<SearchConfig> selectAll();


    /**
     * 根据Key查询配置
     *
     * @param key String
     * @return SearchConfig
     */
    @Select("SELECT id, config_key, config_value, config_title, create_date, update_date FROM search_config WHERE config_key = #{key}")
    @Results({
            @Result(property = "configKey", column = "config_key"),
            @Result(property = "configValue", column = "config_value"),
            @Result(property = "configTitle", column = "config_title"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date")
    })
    SearchConfig selectOneByKey(String key);

    /**
     * 插入数据
     *
     * @param config SearchConfig配置信息
     * @return boolean
     */
    @Insert("insert into search_config (config_key, config_value, " +
            "      config_title, create_date, update_date" +
            "      )" +
            "    values (#{configKey,jdbcType=VARCHAR}, #{configValue,jdbcType=VARCHAR}, " +
            "      #{configTitle,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, #{updateDate,jdbcType=TIMESTAMP}" +
            "      )")
    boolean insert(SearchConfig config);

    /**
     * 根据ID更新数据
     *
     * @param config
     */
    @Update("update search_config" +
            "set config_key = #{configKey,jdbcType=VARCHAR}," +
            "  config_value = #{configValue,jdbcType=VARCHAR}," +
            "  config_title = #{configTitle,jdbcType=VARCHAR}," +
            "  create_date = #{createDate,jdbcType=TIMESTAMP}," +
            "  update_date = #{updateDate,jdbcType=TIMESTAMP}" +
            "where id = #{id,jdbcType=INTEGER}")
    boolean update(SearchConfig config);

    /**
     * 删除对应的数据
     *
     * @param id
     */
    @Delete("delete from search_config where id = #{id,jdbcType=INTEGER}")
    boolean delete(int id);
}
