package com.meitu.search.controller;

import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.HotkeyConfig;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.entity.ResultEntity;
import com.meitu.search.service.impl.HotkeyConfigServiceImpl;
import com.meitu.search.vo.HotkeyConfigVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName SearchController
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 20:23
 */
@RestController
@CrossOrigin("http://localhost:9528")
public class HotkeyController {
    private final HotkeyConfigServiceImpl hotkeyConfigService;

    public HotkeyController(HotkeyConfigServiceImpl hotkeyConfigService) {
        this.hotkeyConfigService = hotkeyConfigService;
    }

    /**
     * 查询
     */
    @RequestMapping(value = "/admin/hotkey", method = RequestMethod.GET)
    public ResultEntity<PageInfo<HotkeyConfigVO>> getList(@RequestParam(value = "page", defaultValue = "0") int page,
                                                          @RequestParam(value = "limit", defaultValue = "10") int pageSize) {
        page = Math.max(page, CommonConstant.COMMON_PAGE_NUM_MIN);
        pageSize = Math.max(pageSize, CommonConstant.COMMON_PAGE_SIZE);
        PageInfo<HotkeyConfig> all = hotkeyConfigService.selectAll(page, pageSize);
        List<HotkeyConfig> list = all.getList();
        List<HotkeyConfigVO> voList = new ArrayList<>();
        for (HotkeyConfig config : list) {
            voList.add(new HotkeyConfigVO(config));
        }
        PageInfo<HotkeyConfigVO> rtn = new PageInfo<>();
        BeanUtils.copyProperties(all, rtn);
        rtn.setList(voList);
        return ResultEntity.successWithData(rtn);
    }


    /**
     * 新增一条数据
     * todo: 修改
     *
     * @return
     */
    @RequestMapping(value = "/admin/hotkey", method = RequestMethod.POST)
    public ResultEntity<HotkeyConfigVO> add(@RequestBody HotkeyConfigVO hotkeyConfigVo, HttpServletResponse response) {
        if (Objects.isNull(hotkeyConfigVo)) {
            response.setStatus(CommonConstant.STATUS_CODE_NOT_FOUND_UNPROCESABLE_ENTITY);
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        HotkeyConfig config = new HotkeyConfig(hotkeyConfigVo);
        HotkeyConfig beforeInsert = hotkeyConfigService.selectOneByKey(config.getSearchKey());
        if(!Objects.isNull(beforeInsert)){
            return ResultEntity.failed("Key值重复");
        }
        boolean insert = hotkeyConfigService.insert(config);
        if (insert) {
            response.setStatus(CommonConstant.STATUS_CODE_SUCCESS_CREATED);
            return ResultEntity.successWithoutData();
        } else {
            response.setStatus(CommonConstant.STATUS_CODE_ERROR);
            return ResultEntity.failed("暂无修改");
        }
    }

    /**
     * 根据ID更新对应的HotkeyConfig
     *
     * @return
     */
    @RequestMapping(value = "/admin/hotkey/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
    public ResultEntity<String> modify(@PathVariable("id") int id,
                                       @RequestBody HotkeyConfigVO hotkeyConfigVo,HttpServletResponse response) {
        if (id <= 0 || hotkeyConfigVo.getId() != id) {
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        boolean update = hotkeyConfigService.update(new HotkeyConfig(hotkeyConfigVo));
        if (update) {
            return ResultEntity.successWithData("");
        } else {
            response.setStatus(CommonConstant.STATUS_CODE_ERROR);
            return ResultEntity.failed(CommonConstant.SYSTEM_ERR);
        }
    }


    @RequestMapping(value = "/admin/hotkey/{id}", method = RequestMethod.DELETE)
    public ResultEntity<String> remove(@PathVariable("id") int id) {
        if (id <= 0) {
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        boolean delete = hotkeyConfigService.delete(id);
        if (delete) {
            return ResultEntity.successWithData("");
        } else {
            return ResultEntity.failed("删除失败，请刷新后重试");
        }
    }

}
