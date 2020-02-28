package com.iep.schedule.service.impl;

import com.alibaba.fastjson.JSON;
import com.iep.schedule.common.constant.ResultEnum;
import com.iep.schedule.common.constant.StatusEnum;
import com.iep.schedule.model.dto.ResultDTO;
import com.iep.schedule.model.dto.ScheduleDTO;
import com.iep.schedule.model.entity.CourseManagement;
import com.iep.schedule.model.entity.Schedule;
import com.iep.schedule.repository.CourseRepository;
import com.iep.schedule.repository.ScheduleRepository;
import com.iep.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public ResultDTO searchCourses(Integer pageNumber, Integer pageSize) {
        // 指定排序字段，分页时从第0页开始查询
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Page<CourseManagement> page = courseRepository.findAllByShowType(StatusEnum.SHOW_TYPE_SUBJECT.getCode(), new PageRequest(pageNumber, pageSize, sort));
        // 获取查询结果l
        List<CourseManagement> courses = page.getContent();
        ArrayList<String> list = new ArrayList<>();
        courses.forEach(courseManagement -> {
            list.add(courseManagement.getLabel());
        });
        if (courses != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("courses", list);
            // 分页当前页数
            map.put("pageNumber", page.getNumber());
            // 分页大小
            map.put("pageSize", page.getSize());
            // 查询结果总数
            map.put("totalCount", page.getTotalElements());
            // 分页总页数
            map.put("totalPage", page.getTotalPages());
            // 是否有下一页
            if ((page.getNumber() + 1) < page.getTotalPages()) {
                map.put("hasNext", 1);
            }
            else {
                map.put("hasNext", 0);
            }
            ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
            resultDTO.setData(JSON.toJSON(map));
            return resultDTO;
        } else {
            return new ResultDTO(ResultEnum.DATA_NOT_FOUND);
        }
    }

    @Override
    @Transactional//事务管理注解
    public ResultDTO saveCourses(String studentId, String year, String semester, String courses) {
        Schedule schedule = scheduleRepository.findScheduleByStudentIdAndYearAndSemester(studentId, year, semester);
        if (schedule == null) {
            Schedule schedule1 = new Schedule();
            schedule1.setStudentId(studentId);
            schedule1.setYear(year);
            schedule1.setSemester(semester);
            schedule1.setCourses(courses);
            scheduleRepository.saveAndFlush(schedule1);
        } else {
            scheduleRepository.updateCourses(studentId, year, semester, courses);
        }
        return new ResultDTO(ResultEnum.SUCCESS);
    }

    @Override
    public ResultDTO searchPersonalSchedule(String studentId, String year, String semester) {
        Schedule schedule = scheduleRepository.findScheduleByStudentIdAndYearAndSemester(studentId, year, semester);
        if (schedule != null) {
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setYear(year);
            scheduleDTO.setSemester(semester);
            scheduleDTO.setCourses(schedule.getCourses());
            ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
            resultDTO.setData(scheduleDTO);
//            JSONObject jsonObject = JSONObject.parseObject(schedule.getCourses());
//            System.out.println(jsonObject.getString("1"));
            return resultDTO;
        } else {
            return new ResultDTO(ResultEnum.DATA_NOT_FOUND);
        }
    }
}
