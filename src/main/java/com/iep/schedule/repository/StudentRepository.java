package com.iep.schedule.repository;

import com.iep.schedule.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * 功能描述: 通过学号查询学生
     *
     * @param: [studentId]
     * @return: com.iep.schedule.model.entity.Student
     * @auther: zbw
     * @date: 14:17 2019/7/19
     */
    Student findStudentByStudentId(String studentId);

    /**
     * 功能描述: 通过姓名查询学生
     *
     * @param: [name]
     * @return: java.util.List<Student>
     * @auther: zbw
     * @date: 16:09 2019/7/20
     */
    List<Student> findAllByNameOrderByStudentId(String name);

    /**
     * 功能描述: 通过班级号查询学生
     *
     * @param: [classId]
     * @return: org.springframework.data.domain.Page<Student>
     * @auther: zbw
     * @date: 17:32 2019/7/19
     */
    Page<Student> findAllByClassId(String classId, Pageable pageable);

}
