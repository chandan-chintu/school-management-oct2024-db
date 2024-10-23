package com.jpahibernate.example.school_management_db.repository;

import com.jpahibernate.example.school_management_db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// it is data layer and it performs database activities
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
