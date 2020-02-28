package com.iep.schedule.model.dto;

import com.iep.schedule.common.constant.ResultEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @功能名称: 封装返回给前端的数据
 * @文件名称: ResultDTO.java
 * @Date: 2019/07/19 17:41
 * @Author: ZBW
 */
@Data
@NoArgsConstructor
public class ResultDTO {
    private Integer code;
    private String message;
    private Object data;

    public ResultDTO(ResultEnum result) {
        setResultEnum(result);
    }

    public void setResultEnum(ResultEnum result) {
        this.code = result.getCode();
        this.message = result.getMessage();
    }
}
