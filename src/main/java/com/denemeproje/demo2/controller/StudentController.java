package com.denemeproje.demo2.controller;

import com.denemeproje.demo2.model.Student;
import com.denemeproje.demo2.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public void postStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }


    @PostMapping("/students/{id}/courses")
    public void addCourseToStudent(@PathVariable Long id,@RequestParam String courseCode){
        studentService.enroll(id,courseCode);
    }

    @PutMapping("/students/{id}")
    public void putStudent(@RequestBody Student student,@PathVariable Long id){
        studentService.updateStudent(student,id);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }



}
