package com.iep.schedule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @功能名称: 学生DTO
 * @文件名称: StudentDTO.java
 * @Date: 2019/07/19 20:46
 * @Author: ZBW
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String studentId;
    private String name;
    private String classId;
}
