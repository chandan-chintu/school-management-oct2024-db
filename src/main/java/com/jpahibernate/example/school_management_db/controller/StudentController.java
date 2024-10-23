package com.jpahibernate.example.school_management_db.controller;

import com.jpahibernate.example.school_management_db.model.Student;
import com.jpahibernate.example.school_management_db.repository.StudentRepository;
import com.jpahibernate.example.school_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    // controller<->service<->repository

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String addStudent(@RequestBody Student student) {
        String response = studentService.saveStudent(student);
        return response;
    }

    @PostMapping("/saveMany")
    public String addStudents(@RequestBody List<Student> studentList) {
        String response = studentService.saveStudents(studentList);
        return response;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @GetMapping("/find/{studentid}")
    public Student findStudentById(@PathVariable("studentid") int studentId){
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @DeleteMapping("/delete/{studentid}")
    public String deleteStudentById(@PathVariable("studentid") int studentId){
        String response = studentService.deleteStudentById(studentId);
        return response;
    }

    // PUT - we update whole fields(like whole object)
    // PATCH - we update specific fields only

    @PutMapping("/updatePut/{studentid}")
    public String updateStudentByPut(@PathVariable("studentid") int studentId, @RequestBody Student student){
        String response = studentService.updateStudentWithPut(studentId,student);
        return response;
    }

    @PatchMapping("/updatePatch/{studentid}")
    public String updateStudentVyPatch(@PathVariable("studentid") int studentId, @RequestParam("grade") String grade, @RequestParam("dob") String dob){
        String response = studentService.updateStudentUsingPatch(studentId, grade, dob);
        return response;
    }

}
