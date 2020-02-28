package com.iep.schedule.service;


import com.iep.schedule.model.dto.ResultDTO;

public interface StudentService {

    /**
     * 功能描述: 根据学号查找学生
     *
     * @param: [studentId]
     * @return: ResultDTO
     * @auther: zbw
     * @date: 19:18 2019/7/19
     */
    ResultDTO searchStudentByStudentId(String studentId);

    /**
     * 功能描述: 根据学号查找学生
     *
     * @param: [name]
     * @return: ResultDTO
     * @auther: zbw
     * @date: 16:05 2019/7/20
     */
    ResultDTO searchStudentByName(String name);

    /**
     * 功能描述: 根据班级号查询学生
     *
     * @param: [classId, pageNumber, pageSize]
     * @return: ResultDTO
     * @auther: zbw
     * @date: 19:20 2019/7/19
     */
    ResultDTO searchStudentsByClassId(String classId, Integer pageNumber, Integer pageSize);
}
