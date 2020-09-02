package com.meitu.search.mapper;

import com.meitu.search.bean.SearchConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SearchConfigMapperTest {

    @Autowired
    SearchConfigMapper searchConfigMapper;

    @Test
    void selectAll() {
        List<SearchConfig> searchConfigs = searchConfigMapper.selectAll();
        assertTrue(searchConfigs.size() > 0);
    }

    @Test
    void selectOneByKey() {
        SearchConfig test = searchConfigMapper.selectOneByKey("test");
        System.out.println(test);
        assertNotNull(test);
    }

    @Test
    void insert() {
        SearchConfig searchConfig = newInstanceSearchConfig();
        System.out.println(searchConfig);
        boolean insert = searchConfigMapper.insert(searchConfig);
        assertTrue(insert);
    }

    @Test
    void update() {
        SearchConfig test = searchConfigMapper.selectOneByKey("test");
        test.setConfigValue("321");
        boolean update = searchConfigMapper.update(test);
        assertTrue(update);
    }

    @Test
    void delete() {
        SearchConfig test = searchConfigMapper.selectOneByKey("test");
        assertNotNull(test);
        boolean delete = searchConfigMapper.delete(test.getId());
        assertTrue(delete);
    }

    private SearchConfig newInstanceSearchConfig() {
        SearchConfig searchConfig = new SearchConfig();
        searchConfig.setConfigKey("test");
        searchConfig.setConfigTitle("测试");
        searchConfig.setConfigValue("123");
        Date date = new Date();
        searchConfig.setCreateDate(date);
        searchConfig.setUpdateDate(date);
        return searchConfig;
    }
}
