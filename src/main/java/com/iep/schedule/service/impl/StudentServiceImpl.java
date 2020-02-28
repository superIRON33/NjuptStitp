package com.iep.schedule.service.impl;

import com.alibaba.fastjson.JSON;
import com.iep.schedule.model.dto.StudentDTO;
import com.iep.schedule.repository.StudentRepository;
import com.iep.schedule.common.constant.ResultEnum;
import com.iep.schedule.model.dto.ResultDTO;
import com.iep.schedule.model.entity.Student;
import com.iep.schedule.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能名称: 查询学生相关接口实现类
 * @文件名称: StudentServiceImpl.java
 * @Date: 2019/07/19 17:10
 * @Author: ZBW
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResultDTO searchStudentByStudentId(String studentId) {
        Student student = studentRepository.findStudentByStudentId(studentId);
        if (student != null) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setName(student.getName());
            studentDTO.setClassId(student.getClassId());
            ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
            resultDTO.setData(studentDTO);
            return resultDTO;
        } else {
            ResultDTO resultDTO = new ResultDTO(ResultEnum.DATA_NOT_FOUND);
            resultDTO.setData(null);
            return resultDTO;
        }
    }

    @Override
    public ResultDTO searchStudentByName(String name) {
        List<Student> students = studentRepository.findAllByNameOrderByStudentId(name);
        ArrayList<StudentDTO> list = new ArrayList<>();
        students.forEach(student -> {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setName(student.getName());
            studentDTO.setClassId(student.getClassId());
            list.add(studentDTO);
        });
        if (list.isEmpty()) {
            ResultDTO resultDTO = new ResultDTO(ResultEnum.DATA_NOT_FOUND);
            resultDTO.setData(null);
            return resultDTO;
        } else {
            ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
            resultDTO.setData(list);
            return resultDTO;
        }
    }

    @Override
    public ResultDTO searchStudentsByClassId(String classId, Integer pageNumber, Integer pageSize) {
        // 指定排序字段，分页时从第0页开始查询
        Sort sort = new Sort(Sort.Direction.ASC, "name");
        Page<Student> page = studentRepository.findAllByClassId(classId, new PageRequest(pageNumber, pageSize, sort));
        // 获取查询结果
        List<Student> students = page.getContent();
        ArrayList<StudentDTO> list = new ArrayList<>();
        students.forEach(student -> {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setName(student.getName());
            studentDTO.setClassId(student.getClassId());
            list.add(studentDTO);
        });
        if (students != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("students", list);
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
        }
        else {
            ResultDTO resultDTO = new ResultDTO(ResultEnum.DATA_NOT_FOUND);
            resultDTO.setData(null);
            return resultDTO;
        }
    }
}
