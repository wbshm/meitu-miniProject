package com.meitu.search.exception;

import com.google.gson.Gson;
import com.meitu.search.constant.CommonConstant;
import com.meitu.search.entity.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName OptExceptionResolver
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 21:34
 */
@ControllerAdvice
public class OptExceptionResolver {
    @ExceptionHandler(value = OptException.class)
    public void optException(OptException exception,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws IOException {
        ResultEntity<Object> failed = ResultEntity.failed(exception.getMessage());
        // 转为Json字符串
        Gson gson = new Gson();
        String json = gson.toJson(failed);
        // 将json字符串作为响应体返回给前端
        response.setStatus(CommonConstant.STATUS_CODE_ERROR);
        response.getWriter().write(json);
    }
}
