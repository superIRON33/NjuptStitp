package com.iep.schedule.common.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @功能名称: 异常返回枚举类
 * @文件名称: ResultEnum.java
 * @Date: 2019/07/19 15:39
 * @Author: ZBW
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    /**
     * 请求成功
     */
    SUCCESS(1, "success"),

    /**
     * 请求失败
     */
    FAIL(0, "fail"),

    /**
     * 找不到数据
     */
    DATA_NOT_FOUND(-1, "can not find data"),

    /**
     * 数据已经存在
     */
    DATA_ALREADY_EXISTS(-2, "data already exists");

    private Integer code;
    private String message;

}
