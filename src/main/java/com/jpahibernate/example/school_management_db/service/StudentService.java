package com.jpahibernate.example.school_management_db.service;

import com.jpahibernate.example.school_management_db.model.Student;
import com.jpahibernate.example.school_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it contains business logic
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(Student student){
        studentRepository.save(student);
        return "Student saved successfully";
    }

    public String saveStudents(List<Student> studentList){
        studentRepository.saveAll(studentList);
        return "Students saved successfully";
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student getStudentById(int studentId){
        Student student = studentRepository.findById(studentId).get();
//        Optional<Student> student = studentRepository.findById(studentId);
//        student.get();
        return student;
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "Student with id : "+studentId+" got deleted";
    }

    public String updateStudentWithPut(int studentId, Student newStudentRequest){
        // first find student with id
        // if student present update it
        // else no need to update
        Student student = getStudentById(studentId);
        if(student!=null){
            studentRepository.save(newStudentRequest);
            return " Student updated success";
        } else{
            return " cannot find student with id : "+studentId;
        }
    }

    public String updateStudentUsingPatch(int studentId, String grade, String dob){
        Student student = getStudentById(studentId);
        if(student!=null){
            student.setGrade(grade);
            student.setDob(dob);
            studentRepository.save(student);
            return " Student updated success";
        } else{
            return " cannot find student with id : "+studentId;
        }
    }

}
