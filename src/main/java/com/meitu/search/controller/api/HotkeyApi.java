package com.meitu.search.controller.api;

import com.meitu.search.bean.HotkeyConfig;
import com.meitu.search.entity.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SearchApi
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 20:23
 */
@RestController
public class HotkeyApi {

    @RequestMapping(value = "/api/hotkey", method = RequestMethod.GET)
    public ResultEntity<List<HotkeyConfig>> getHotkey() {
        return null;
    }

    @RequestMapping(value = "/api/search", method = RequestMethod.POST)
    public ResultEntity<String> search(@RequestParam(value = "key", defaultValue = "") String key) {
        return null;
    }

}
