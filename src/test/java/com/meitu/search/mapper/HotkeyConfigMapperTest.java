package com.meitu.search.mapper;

import com.meitu.search.bean.HotkeyConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
class HotkeyConfigMapperTest {

    @Autowired
    HotkeyConfigMapper hotkeyConfigMapper;

    @Test
    void selectAll() {
        List<HotkeyConfig> hotkeyConfigs = hotkeyConfigMapper.selectAll();
        assert hotkeyConfigs.size() != 0;
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
        assert insert;
        List<HotkeyConfig> hotkeyConfigs = hotkeyConfigMapper.selectListByAllow(new Date(), 1);
        assert hotkeyConfigs.size() != 0;
    }

    @Test
    void selectOneById() {
        HotkeyConfig hotkeyConfig = hotkeyConfigMapper.selectOneById(2);
        Assert.assertNotNull(hotkeyConfig);
    }

    @Test
    void insert() {
        HotkeyConfig hotkeyConfig = newInstanceHotkeyConfig();
        boolean insert = hotkeyConfigMapper.insert(hotkeyConfig);
        Assert.assertTrue(insert);
    }

    @Test
    void update() {
        HotkeyConfig hotkeyConfig = hotkeyConfigMapper.selectOneById(2);
        hotkeyConfig.setKeyStatus((byte) 1);
        boolean update = hotkeyConfigMapper.update(hotkeyConfig);
        Assert.assertTrue(update);
    }

    @Test
    void delete() {
        boolean delete = hotkeyConfigMapper.delete(3);
        Assert.assertTrue(delete);
    }

    private HotkeyConfig newInstanceHotkeyConfig() {
        HotkeyConfig hotkeyConfig = new HotkeyConfig();
        hotkeyConfig.setSearchKey(getRandomString(3));
        hotkeyConfig.setKeyOrder((byte) 0);
        hotkeyConfig.setKeyStatus((byte) 0);

        Date date = new Date();
        hotkeyConfig.setCreateDate(date);
        hotkeyConfig.setUpdateDate(date);
        hotkeyConfig.setStartTime(date);
        hotkeyConfig.setEndTime(date);
        return hotkeyConfig;
    }

    private String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
