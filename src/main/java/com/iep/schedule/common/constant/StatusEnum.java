package com.iep.schedule.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @功能名称: 状态值枚举类
 * @文件名称: StatusEnum.java
 * @Date: 2019/07/21 21:11
 * @Author: ZBW
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    /**
     * showType为1, 表示学科
     */
    SHOW_TYPE_SUBJECT(1),

    /**
     * 第一学期
     */
    FIRST_SEMESTER(1),

    /**
     * 第二学期
     */
    SECOND_SEMESTER(2);

    private Integer code;
}
