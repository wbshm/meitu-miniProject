package com.meitu.search.vo;

import com.meitu.search.bean.HotkeyConfig;
import com.meitu.search.bean.SearchConfig;
import com.meitu.search.bean.SearchHistory;

/**
 * @ClassName SearchHistoryVo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/3 9:25
 */
public class SearchHistoryVO {
    private int order;
    private int count;
    private String key;

    public SearchHistoryVO(SearchHistory history) {
        this.setKey(history.getSearchKey());
        this.setCount(history.getCountNum());
    }

    public SearchHistoryVO(HotkeyConfig config) {
        this.setKey(config.getSearchKey());
        this.setOrder(config.getKeyOrder());
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
