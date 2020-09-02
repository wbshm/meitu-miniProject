package com.meitu.search.mapper;

import com.meitu.search.bean.HotkeyConfig;
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
class HotkeyConfigMapperTest {

    @Autowired
    HotkeyConfigMapper hotkeyConfigMapper;

    @Test
    void selectAll() {
        List<HotkeyConfig> hotkeyConfigs = hotkeyConfigMapper.selectAll();
        assertNotEquals(0, hotkeyConfigs.size());
    }

    @Test
    void selectListByAllow() {
        HotkeyConfig hotkeyConfig = newInstanceHotkeyConfig();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        hotkeyConfig.setEndTime(calendar.getTime());
        hotkeyConfig.setKeyOrder((byte) 2);
        boolean insert = hotkeyConfigMapper.insert(hotkeyConfig);
        assertTrue(insert);
        List<HotkeyConfig> hotkeyConfigs = hotkeyConfigMapper.selectListByAllow(new Date(), 1);
        assertNotEquals(0, hotkeyConfigs.size());
    }

    @Test
    void selectOneById() {
        HotkeyConfig hotkeyConfig = hotkeyConfigMapper.selectOneById(2);
        assertNotNull(hotkeyConfig);
    }

    @Test
    void insert() {
        HotkeyConfig hotkeyConfig = newInstanceHotkeyConfig();
        boolean insert = hotkeyConfigMapper.insert(hotkeyConfig);
        assertTrue(insert);
    }

    @Test
    void update() {
        HotkeyConfig hotkeyConfig = hotkeyConfigMapper.selectOneById(2);
        hotkeyConfig.setKeyStatus((byte) 1);
        boolean update = hotkeyConfigMapper.update(hotkeyConfig);
        assertTrue(update);
    }

    @Test
    void delete() {
        boolean delete = hotkeyConfigMapper.delete(3);
        assertTrue(delete);
    }

    private HotkeyConfig newInstanceHotkeyConfig() {
        HotkeyConfig hotkeyConfig = new HotkeyConfig();
        hotkeyConfig.setSearchKey(StringUtil.getRandomString(3));
        hotkeyConfig.setKeyOrder((byte) 0);
        hotkeyConfig.setKeyStatus((byte) 0);

        Date date = new Date();
        hotkeyConfig.setCreateDate(date);
        hotkeyConfig.setUpdateDate(date);
        hotkeyConfig.setStartTime(date);
        hotkeyConfig.setEndTime(date);
        return hotkeyConfig;
    }
}
