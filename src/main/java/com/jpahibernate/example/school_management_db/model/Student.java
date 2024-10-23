package com.jpahibernate.example.school_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;

@Entity // it refers that this is model/entity class
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")// it will create a table inside database with name student
public class Student {

    @Id // it is primary key and cannot have duplicate values
    @Column(name = "student_id") // it created a column in database with name student_id
    private int studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "grade", nullable = false)// nullable = false - it is mandatory to give the value and it cannot take null values
    private String grade;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "section", nullable = false)
    private String section;

}
