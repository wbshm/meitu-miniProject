package com.meitu.search.bean;

import java.util.Date;

public class SearchHistory {
    private Integer id;

    private String searchKey;

    private int countNum;

    private Date createDate;

    public SearchHistory() {
    }

    public SearchHistory(HotkeyConfig config) {
        this.setSearchKey(config.getSearchKey());
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
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
                "id=" + id +
                ", searchKey='" + searchKey + '\'' +
                ", countNum=" + countNum +
                ", createDate=" + createDate +
                '}';
    }
}
