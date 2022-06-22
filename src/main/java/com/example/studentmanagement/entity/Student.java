package com.example.studentmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@XmlRootElement
@Table(name="student")
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="STUDENT_SEQ" )
    @SequenceGenerator(name="STUDENT_SEQ", sequenceName="STUDENT_SEQ" , allocationSize=1)
    @Column(nullable = false)
    private int id;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(nullable = false)
    private Date birthday;

    @Column(name = "class_name",nullable = false)
    private String className;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String hometown;

    @Column(nullable = false)
    private String gender;

    @Column(name = "average_mark")
    private float averageMark;

}
