package com.meitu.search.controller;

import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.SearchConfig;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.entity.ResultEntity;
import com.meitu.search.service.ISearchConfigService;
import com.meitu.search.util.StringUtil;
import com.meitu.search.vo.SearchConfigVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName SearchConfigController
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 9:11
 */
@RestController
@CrossOrigin("http://localhost:9528")
public class SearchConfigController {

    private final ISearchConfigService searchConfigService;

    public SearchConfigController(ISearchConfigService searchConfigService) {
        this.searchConfigService = searchConfigService;
    }

    /**
     * 添加删除修改
     */
    @RequestMapping(value = "/admin/search_config", method = RequestMethod.GET)
    public ResultEntity<PageInfo<SearchConfigVO>> getList(@RequestParam(value = "page", defaultValue = "0") int page) {
        page = Math.max(page, CommonConstant.COMMON_PAGE_NUM_MIN);
        PageInfo<SearchConfig> searchConfigPageInfo = searchConfigService.selectAll(page, CommonConstant.COMMON_PAGE_SIZE);
        List<SearchConfig> list = searchConfigPageInfo.getList();
        List<SearchConfigVO> voList = new ArrayList<>();
        for (SearchConfig config : list) {
            voList.add(new SearchConfigVO(config));
        }
        PageInfo<SearchConfigVO> rtn = new PageInfo<>();
        BeanUtils.copyProperties(searchConfigPageInfo, rtn);
        rtn.setList(voList);
        return ResultEntity.successWithData(rtn);
    }

    /**
     * 新增
     *
     * @param searchConfigVo
     * @return
     */
    @RequestMapping(value = "/admin/search_config", method = RequestMethod.POST)
    public ResultEntity<String> insert(@RequestBody SearchConfigVO searchConfigVo,
                                       HttpServletResponse response) {
        if (Objects.isNull(searchConfigVo)) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        boolean checkEmpty = StringUtil.isEmpty(searchConfigVo.getConfigKey()) || StringUtil.isEmpty(searchConfigVo.getConfigValue());
        if (checkEmpty) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        SearchConfig beforeInsert = searchConfigService.selectOneByKey(searchConfigVo.getConfigKey());
        if (!Objects.isNull(beforeInsert)) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed("Key值重复");
        }
        boolean insert = searchConfigService.insert(new SearchConfig(searchConfigVo));
        if (insert) {
            response.setStatus(CommonConstant.STATUS_CODE_SUCCESS_CREATED);
            return ResultEntity.successWithoutData();
        } else {
            response.setStatus(CommonConstant.STATUS_CODE_ERROR);
            return ResultEntity.failed(CommonConstant.SYSTEM_ERR);
        }
    }

    /**
     * 根据ID修改元素
     *
     * @param id
     * @param searchConfigVo
     * @param response
     * @return
     */
    @RequestMapping(value = "/admin/search_config/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResultEntity<String> modify(@PathVariable("id") int id, @RequestBody SearchConfigVO searchConfigVo, HttpServletResponse response) {
        if (id <= 0 || id != searchConfigVo.getId()) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        boolean update = searchConfigService.update(new SearchConfig(searchConfigVo));
        if (update) {
            response.setStatus(CommonConstant.STATUS_CODE_SUCCESS_CREATED);
            return ResultEntity.successWithoutData();
        } else {
            response.setStatus(CommonConstant.STATUS_CODE_ERROR);
            return ResultEntity.failed(CommonConstant.SYSTEM_ERR);
        }
    }

    /**
     * 根据ID删除元素
     *
     * @param id
     * @param response
     * @return
     */
    @RequestMapping(value = "/admin/search_config/{id}", method = {RequestMethod.DELETE})
    public ResultEntity<String> remove(@PathVariable("id") int id, HttpServletResponse response) {
        if (id <= 0) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        boolean delete = searchConfigService.delete(id);
        if (delete) {
            return ResultEntity.successWithData("");
        } else {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_GONE);
            return ResultEntity.failed("删除失败，请刷新重试");
        }
    }
}
