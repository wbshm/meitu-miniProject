package com.meitu.search.vo;

import com.meitu.search.bean.SearchConfig;

import java.util.Date;

/**
 * @ClassName SearchConfigVo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 22:55
 */
public class SearchConfigVO {

    private Integer id;

    private String configKey;

    private String configValue;

    private String configTitle;

    private long createDate;

    private long updateDate;

    public SearchConfigVO() {
    }

    public SearchConfigVO(SearchConfig config) {
        this.setId(config.getId());
        this.setConfigKey(config.getConfigKey());
        this.setConfigValue(config.getConfigValue());
        this.setConfigTitle(config.getConfigTitle());
        this.setCreateDate(config.getCreateDate().getTime());
        this.setUpdateDate(config.getUpdateDate().getTime());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigTitle() {
        return configTitle;
    }

    public void setConfigTitle(String configTitle) {
        this.configTitle = configTitle;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }
}

