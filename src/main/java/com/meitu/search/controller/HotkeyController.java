package com.meitu.search.controller;

import com.github.pagehelper.PageInfo;
import com.meitu.search.bean.HotkeyConfig;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.entity.ResultEntity;
import com.meitu.search.service.impl.HotkeyConfigServiceImpl;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SearchController
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 20:23
 */
@RestController
public class HotkeyController {
    private final HotkeyConfigServiceImpl hotkeyConfigService;

    public HotkeyController(HotkeyConfigServiceImpl hotkeyConfigService) {
        this.hotkeyConfigService = hotkeyConfigService;
    }

    /**
     * 查询
     */
    @RequestMapping(value = "/admin/hotkey", method = RequestMethod.GET)
    public ResultEntity<PageInfo<HotkeyConfig>> getList(@RequestParam(value = "page", defaultValue = "0") int page) {
        page = Math.max(page, CommonConstant.COMMON_PAGE_NUM_MIN);
        PageInfo<HotkeyConfig> all = hotkeyConfigService.getAll(page, CommonConstant.COMMON_PAGE_SIZE);
        return ResultEntity.successWithData(all);
    }


    /**
     * 新增一条数据
     * todo: 修改
     *
     * @return
     */
    @RequestMapping(value = "/admin/hotkey", method = RequestMethod.POST)
    public ResultEntity<String> add(HotkeyConfig hotkeyConfig, HttpServletResponse response) {
        System.out.println(hotkeyConfig);
        return null;
    }

    /**
     * 根据ID更新对应的HotkeyConfig
     *
     * @param id
     * @param hotkeyConfig
     * @return
     */
    @RequestMapping(value = "/admin/hotkey/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
    public ResultEntity<String> modify(
            @PathVariable("id") int id,
            HotkeyConfig hotkeyConfig) {
        if (id <= 0 || hotkeyConfig.getId() != id) {
            return ResultEntity.failed(CommonConstant.ERR_ILLEGAL_PARAM);
        }
        hotkeyConfigService.update(hotkeyConfig);
        return ResultEntity.successWithData("");
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
