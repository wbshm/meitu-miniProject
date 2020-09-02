package com.meitu.search.bean;

import com.meitu.search.vo.SearchConfigVO;

import java.util.Date;

public class SearchConfig {
    private Integer id;

    private String configKey;

    private String configValue;

    private String configTitle;

    private Date createDate;

    private Date updateDate;

    public SearchConfig() {
    }

    public SearchConfig(SearchConfigVO vo) {
        this.setId(vo.getId());
        this.setConfigKey(vo.getConfigKey());
        this.setConfigValue(vo.getConfigValue());
        this.setConfigTitle(vo.getConfigTitle());
        this.setCreateDate(new Date(vo.getCreateDate()));
        this.setUpdateDate(new Date(vo.getUpdateDate()));
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
        this.configKey = configKey == null ? null : configKey.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public String getConfigTitle() {
        return configTitle;
    }

    public void setConfigTitle(String configTitle) {
        this.configTitle = configTitle == null ? null : configTitle.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


}
