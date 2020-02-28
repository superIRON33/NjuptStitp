package com.iep.schedule.repository;

import com.iep.schedule.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    /**
     * 功能描述: 通过studentId查找学生课表
     *
     * @param: [studentId, year, semester]
     * @return: [com.iep.schedule.model.entity.Schedule]
     * @auther: zbw
     * @date: 9:00 2019/7/22
     */
    Schedule findScheduleByStudentIdAndYearAndSemester(String studentId, String year, String semester);

    /**
     * 功能描述: 修改学生课表
     *
     * @param: [studentId, year, semester, courses]
     * @return: void
     * @auther: zbw
     * @date: 12:15 2019/8/5
     */
    @Modifying
    @Transactional
    @Query("update Schedule schedule set schedule.courses = :courses where schedule.studentId = :studentId and schedule.year = :year and schedule.semester = :semester")
    void updateCourses(@Param("studentId") String studentId,
                       @Param("year") String year,
                       @Param("semester") String semester,
                       @Param("courses") String courses);

    @Override
    <S extends Schedule> S saveAndFlush(S s);
}
