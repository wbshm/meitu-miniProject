package com.meitu.search.bean;

import java.util.Date;

public class HotkeyConfig {
    private Integer id;

    private String searchKey;

    private Byte keyStatus;

    private Byte keyOrder;

    private Date startTime;

    private Date endTime;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }

    public Byte getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(Byte keyStatus) {
        this.keyStatus = keyStatus;
    }

    public Byte getKeyOrder() {
        return keyOrder;
    }

    public void setKeyOrder(Byte keyOrder) {
        this.keyOrder = keyOrder;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return "SearchConfig{" +
                "id=" + id +
                ", searchKey='" + searchKey + '\'' +
                ", keyStatus=" + keyStatus +
                ", keyOrder=" + keyOrder +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
