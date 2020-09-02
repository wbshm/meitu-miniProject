package com.meitu.search.controller;

import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.SearchConfig;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.entity.ResultEntity;
import com.meitu.search.service.ISearchConfigService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SearchConfigController
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 9:11
 */
@RestController
public class SearchConfigController {

    private final ISearchConfigService searchConfigService;

    public SearchConfigController(ISearchConfigService searchConfigService) {
        this.searchConfigService = searchConfigService;
    }


    /**
     * 添加删除修改
     */
    @RequestMapping(value = "/admin/search_config", method = RequestMethod.GET)
    public ResultEntity<PageInfo<SearchConfig>> getList(@RequestParam(value = "page", defaultValue = "0") int page) {
        page = Math.max(page, CommonConstant.COMMON_PAGE_NUM_MIN);
        PageInfo<SearchConfig> searchConfigPageInfo = searchConfigService.selectAll(page, CommonConstant.COMMON_PAGE_SIZE);
        return ResultEntity.successWithData(searchConfigPageInfo);
    }


    /**
     * 新增
     *
     * @param searchConfig
     * @return
     */
    @RequestMapping(value = "/admin/search_config", method = RequestMethod.POST)
    public ResultEntity<String> insert(SearchConfig searchConfig) {

        return ResultEntity.successWithData("");
    }

    @RequestMapping(value = "/admin/search_config/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResultEntity<String> modify(@PathVariable("id") int id, SearchConfig searchConfig, HttpServletResponse response) {
        if (id <= 0 || id != searchConfig.getId()) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        return null;
    }

    @RequestMapping(value = "/admin/search_config/{id}", method = {RequestMethod.DELETE})
    public ResultEntity<String> remove(@PathVariable("id") int id, HttpServletResponse response) {
        if (id <= 0) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        boolean delete = searchConfigService.delete(id);
        if (delete) {
            response.setStatus(CommonConstant.STATUS_CODE_SUCCESS_NO_CONTENT);
            return null;
        } else {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_GONE);
            return ResultEntity.failed("删除失败，请刷新重试");
        }
    }
}
