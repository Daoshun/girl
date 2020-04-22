package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * Created by Daoshun
 * 2020/4/16 22:08
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

