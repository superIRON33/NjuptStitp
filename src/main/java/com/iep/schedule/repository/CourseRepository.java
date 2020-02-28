package com.iep.schedule.repository;

import com.iep.schedule.model.entity.CourseManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseManagement, Integer> {

    /**
     * 功能描述: 通过showType(学科)查询当前可选学科
     *
     * @param: [showType]
     * @return: org.springframework.data.domain.Page<CourseManagement>
     * @auther: zbw
     * @date: 15:26 2019/7/19
     */
    Page<CourseManagement> findAllByShowType(Integer showType, Pageable pageable);
}
