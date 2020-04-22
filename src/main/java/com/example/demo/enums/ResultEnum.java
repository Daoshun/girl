package com.example.demo.enums;

/**
 * Created by Daoshun
 * 2020/4/17 9:29
 * 枚举类型，一般只需要get方法，放在一起统一管理，统一维护
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "该女生正在上小学"),
    JUNIOR_SCHOOL(101, "该女生正在上中学"),
    UNKNOW_AGE(102, "该女生年龄不在判断范围内"),
    UNKNOW_ID(103, "该ID不存在"),
    EASY_GIRL(200, "EASY_GIRL"),
    DIFFICULT_GIRL(201, "DIFFICULT_GIRL")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
