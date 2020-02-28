package com.iep.schedule.controller;

import com.iep.schedule.VO.CourseVO;
import com.iep.schedule.model.dto.ResultDTO;
import com.iep.schedule.service.ScheduleService;
import com.iep.schedule.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin()//解决跨域问题
@RestController
@RequestMapping("/scheduleSet")
public class ScheduleController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(value = "/studentId/student")
    public ResultDTO searchStudentByStudentId(@RequestParam String studentId) {

        return studentService.searchStudentByStudentId(studentId);
    }

    @GetMapping(value = "/name/student")
    public ResultDTO searchStudentByName(@RequestParam String name) {
        return studentService.searchStudentByName(name);
    }

    @GetMapping(value = "/classId/student")
    public ResultDTO searchStudentsByClassId(@RequestParam String classId,
                                             @RequestParam Integer pageNumber,
                                             @RequestParam Integer pageSize) {

        return studentService.searchStudentsByClassId(classId, pageNumber, pageSize);
    }

    @GetMapping(value = "/courses")
    public ResultDTO searchCourses(@RequestParam Integer pageNumber,
                                   @RequestParam Integer pageSize) {

        return scheduleService.searchCourses(pageNumber, pageSize);
    }

    @PostMapping(value = "/personalSchedule/save")
    public ResultDTO saveCourses(@RequestBody CourseVO courses) {
        log.info("courses={}",courses);
        return scheduleService.saveCourses(courses.getStudentId(), courses.getYear(), courses.getSemester(), courses.getCourses());
    }

    @GetMapping(value = "/personalSchedule")
    public ResultDTO searchPersonalSchedule(@RequestParam String studentId,
                                         @RequestParam String year,
                                         @RequestParam String semester) {
        return scheduleService.searchPersonalSchedule(studentId, year, semester);
    }
}
