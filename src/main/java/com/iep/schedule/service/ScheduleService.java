package com.iep.schedule.service;

import com.iep.schedule.model.dto.ResultDTO;

public interface ScheduleService {

    /**
     * 功能描述: 通过showType(学科)为1,查询当前可选学科
     *
     * @param: [pageNumber, pageSize]
     * @return: ResultDTO
     * @auther: zbw
     * @date: 15:32 2019/7/22
     */
    ResultDTO searchCourses(Integer pageNumber, Integer pageSize);

    /**
     * 功能描述: 保存当前已选课程
     *
     * @param: [studentId, year, semester, courses]
     * @return: ResultDTO
     * @auther: zbw
     * @date: 15:41 2019/7/22
     */
    ResultDTO saveCourses(String studentId, String year, String semester, String courses);

    /**
     * 功能描述: 显示当前学生个人课表
     *
     * @param: [studentId, year, semester]
     * @return: ResultDTO
     * @auther: zbw
     * @date: 22:59 2019/7/22
     */
    ResultDTO searchPersonalSchedule(String studentId, String year, String semester);
}
