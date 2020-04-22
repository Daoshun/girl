package com.example.demo.utils;

import com.example.demo.domain.Result;

/**
 * Created by Daoshun
 * 2020/4/15 15:25
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result moneyCheap(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("EasyGirl");
        result.setData(object);
        return result;
    }

    public static Result moneyExpensive(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("DifficultGirl");
        result.setData(object);
        return result;
    }

}
