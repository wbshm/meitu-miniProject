package com.meitu.search.vo;

import com.meitu.search.bean.HotkeyConfig;

/**
 * @ClassName HotkeyConfigVO
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 18:06
 */
public class HotkeyConfigVO {
    private Integer id;

    private String searchKey;

    private Byte keyStatus;

    private Byte keyOrder;

    private long startTime;

    private long endTime;

    private long createDate;

    private long updateDate;

    public HotkeyConfigVO() {
    }

    public HotkeyConfigVO(HotkeyConfig config) {
        this.setId(config.getId());
        this.setSearchKey(config.getSearchKey());
        this.setKeyStatus(config.getKeyStatus());
        this.setKeyOrder(config.getKeyOrder());
        this.setUpdateDate(config.getUpdateDate().getTime());
        this.setCreateDate(config.getCreateDate().getTime());
        this.setEndTime(config.getEndTime().getTime());
        this.setStartTime(config.getStartTime().getTime());
    }

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
        this.searchKey = searchKey;
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

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return "HotkeyConfigVO{" +
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
