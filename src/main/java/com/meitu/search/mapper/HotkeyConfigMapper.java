package com.meitu.search.mapper;

import com.meitu.search.bean.HotkeyConfig;
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
public interface HotkeyConfigMapper {

    /**
     * 查询所有的配置信息
     *
     * @return SearchConfig List
     */
    @Select("SELECT id, search_key, key_status, key_order, start_time, end_time, create_date, update_date" +
            " FROM hotkey_config")
    @Results({
            @Result(property = "searchKey", column = "search_key"),
            @Result(property = "keyStatus", column = "key_status"),
            @Result(property = "keyOrder", column = "key_order"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date"),
    })
    List<HotkeyConfig> selectAll();

    /**
     * 根据Key来模糊查找
     *
     * @return SearchConfig List
     */
    @Select("SELECT id, search_key, key_status, key_order, start_time, end_time, create_date, update_date" +
            " FROM hotkey_config where start_time<= #{date,jdbcType=TIMESTAMP} " +
            "AND end_time> #{date,jdbcType=TIMESTAMP} " +
            "AND key_status=0 " +
            "AND key_order>0 " +
            "order by key_order asc " +
            "limit #{limit,jdbcType=INTEGER}")
    @Results({
            @Result(property = "searchKey", column = "search_key"),
            @Result(property = "keyStatus", column = "key_status"),
            @Result(property = "keyOrder", column = "key_order"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date"),
    })
    List<HotkeyConfig> selectListByAllow(Date date, int limit);


    /**
     * 根据ID 查询对应的数据
     *
     * @param key String
     * @return SearchConfig
     */
    @Select("SELECT id, search_key, key_status, key_order, start_time, end_time, create_date, update_date FROM hotkey_config WHERE search_key = #{key} limit 1")
    @Results({
            @Result(property = "searchKey", column = "search_key"),
            @Result(property = "keyStatus", column = "key_status"),
            @Result(property = "keyOrder", column = "key_order"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date"),
    })
    HotkeyConfig selectOneByKey(String key);

    /**
     * 插入数据
     *
     * @param config SearchConfig配置信息
     * @return boolean
     */
    @Insert("insert into hotkey_config (search_key, " +
            "      key_status, key_order, start_time, " +
            "      end_time, create_date, update_date" +
            "      )" +
            "    values (#{searchKey,jdbcType=VARCHAR}," +
            "      #{keyStatus,jdbcType=TINYINT}, #{keyOrder,jdbcType=TINYINT}, #{startTime,jdbcType=TIMESTAMP}, " +
            "      #{endTime,jdbcType=TIMESTAMP}, #{createDate,jdbcType=TIMESTAMP}, #{updateDate,jdbcType=TIMESTAMP}" +
            "      )")
    boolean insert(HotkeyConfig config);

    /**
     * 根据ID更新数据
     *
     * @param config
     */
    @Update("update hotkey_config" +
            "    set search_key = #{searchKey,jdbcType=VARCHAR}," +
            "      key_status = #{keyStatus,jdbcType=TINYINT}," +
            "      key_order = #{keyOrder,jdbcType=TINYINT}," +
            "      start_time = #{startTime,jdbcType=TIMESTAMP}," +
            "      end_time = #{endTime,jdbcType=TIMESTAMP}," +
            "      create_date = #{createDate,jdbcType=TIMESTAMP}," +
            "      update_date = #{updateDate,jdbcType=TIMESTAMP}" +
            "    where id = #{id,jdbcType=INTEGER}")
    boolean update(HotkeyConfig config);

    /**
     * 删除对应的数据
     *
     * @param id
     */
    @Delete("delete from hotkey_config where id = #{id,jdbcType=INTEGER}")
    boolean delete(int id);
}
