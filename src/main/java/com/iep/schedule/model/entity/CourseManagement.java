package com.iep.schedule.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "coursemanagement")
public class CourseManagement {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "label")
    private String label;

    @Column(name = "show_type")
    private Integer showType;

    @Column(name = "children_id")
    private String childrenId;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "delete_status")
    private Integer deleteStatus;

    @Column(name = "father")
    private Integer father;

    @Column(name = "help")
    private Integer help;

    @Column(name = "producer_id")
    private Integer producerId;
}
