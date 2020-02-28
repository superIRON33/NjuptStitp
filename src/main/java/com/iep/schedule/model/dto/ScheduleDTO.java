package com.iep.schedule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @功能名称: 课表DTO
 * @文件名称: ScheduleDTO.java
 * @Date: 2019/07/25 20:46
 * @Author: ZBW
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private String year;
    private String semester;
    private String courses;
}
