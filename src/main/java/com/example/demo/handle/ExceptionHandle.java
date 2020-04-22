package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.exception.GirlException;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Daoshun
 * 2020/4/16 21:18
 */

/** 异常捕获 */

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if(e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }
        return ResultUtil.error(-1, "未知错误");
    }
}
