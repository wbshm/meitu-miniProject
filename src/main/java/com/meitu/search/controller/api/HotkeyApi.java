package com.meitu.search.controller.api;

import com.meitu.search.bean.HotkeyConfig;
import com.meitu.search.bean.SearchConfig;
import com.meitu.search.bean.SearchHistory;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.constant.SearchConfigConstant;
import com.meitu.search.entity.ResultEntity;
import com.meitu.search.service.IHotkeyConfigService;
import com.meitu.search.service.ISearchConfigService;
import com.meitu.search.service.ISearchHistoryService;
import com.meitu.search.util.StringUtil;
import com.meitu.search.vo.SearchHistoryVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @ClassName SearchApi
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 20:23
 */
@RestController
public class HotkeyApi {
    private final IHotkeyConfigService hotkeyConfigService;
    private final ISearchConfigService searchConfigService;
    private final ISearchHistoryService searchHistoryService;

    public HotkeyApi(IHotkeyConfigService hotkeyConfigService, ISearchConfigService searchConfigService, ISearchHistoryService searchHistoryService) {
        this.hotkeyConfigService = hotkeyConfigService;
        this.searchConfigService = searchConfigService;
        this.searchHistoryService = searchHistoryService;
    }


    /**
     * 管理后台可以配制热词的更新周期 X 小时，
     * 返回的热词数量 K 个；
     *
     * @return
     */
    @RequestMapping(value = "/api/hotkey", method = RequestMethod.GET)
    public ResultEntity<List<SearchHistoryVO>> getHotkey(HttpServletResponse response) {
        SearchConfig frequencyConfig = searchConfigService.selectOneByKey(SearchConfigConstant.HOTKEY_UPDATE_FREQUENCY);
        SearchConfig numConfig = searchConfigService.selectOneByKey(SearchConfigConstant.HOTKEY_NUM);
        if (Objects.isNull(frequencyConfig) || Objects.isNull(numConfig)) {
            response.setStatus(CommonConstant.STATUS_CODE_ERROR);
            return ResultEntity.failed("系统配置异常，请稍后再试");
        }
        // 获取运营配置的关键字信息
        int hotkeyNum = Integer.parseInt(numConfig.getConfigValue());
        int frequency = Integer.parseInt(frequencyConfig.getConfigValue());
        List<HotkeyConfig> hotkeyConfigs = hotkeyConfigService.selectRankList(hotkeyNum);
        List<SearchHistory> searchHistories = getSearchHistories(frequency, hotkeyNum);
        LinkedList<SearchHistoryVO> mergeRes = mergeRes(searchHistories, hotkeyConfigs);
        List<SearchHistoryVO> rtn = mergeRes.subList(0, Math.min(hotkeyNum, mergeRes.size()));
        return ResultEntity.successWithData(rtn);
    }

    private List<SearchHistory> getSearchHistories(int frequency, int num) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.HOUR, -frequency);
        Date before = calendar.getTime();
        return searchHistoryService.countHistory(before, num);
    }

    /**
     * 合并两个结果集
     *
     * @param searchHistories
     * @param hotkeyConfigs
     * @return
     */
    private LinkedList<SearchHistoryVO> mergeRes(List<SearchHistory> searchHistories, List<HotkeyConfig> hotkeyConfigs) {
        LinkedList<SearchHistoryVO> rtn;
        if (!Objects.isNull(searchHistories)) {
            rtn = new LinkedList<>();
            for (SearchHistory history : searchHistories) {
                rtn.add(new SearchHistoryVO(history));
            }
            int keyOrder, keyIndex;
            SearchHistoryVO historyVO;
            for (HotkeyConfig config : hotkeyConfigs) {
                historyVO = new SearchHistoryVO(config);
                rtn.remove(historyVO);
                for (SearchHistoryVO vo : rtn) {
                    if (historyVO.getKey().equals(vo.getKey())) {
                        rtn.remove(vo);
                    }
                }
                keyOrder = config.getKeyOrder();
                if (rtn.size() < keyOrder) {
                    rtn.add(new SearchHistoryVO(config));
                } else {
                    keyIndex = keyOrder - 1;
                    rtn.add(keyIndex, new SearchHistoryVO(config));
                }

            }
        } else if (!Objects.isNull(hotkeyConfigs)) {
            rtn = new LinkedList<>();
            for (HotkeyConfig config : hotkeyConfigs) {
                rtn.add(new SearchHistoryVO(config));
            }
        } else {
            rtn = new LinkedList<>();
        }
        return rtn;
    }

    /**
     * 搜索接口，新增一条搜索记录。
     *
     * @param key
     * @param response
     * @return
     */
    @RequestMapping(value = "/api/search", method = RequestMethod.GET)
    public ResultEntity<String> search(@RequestParam(value = "key", defaultValue = "") String key, HttpServletResponse response) {
        if (StringUtil.isEmpty(key)) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setSearchKey(key);
        boolean insert = searchHistoryService.insert(searchHistory);
        if (insert) {
            return ResultEntity.successWithData(key);
        } else {
            response.setStatus(CommonConstant.STATUS_CODE_ERROR);
            return ResultEntity.failed(CommonConstant.SYSTEM_ERR);
        }
    }

}
