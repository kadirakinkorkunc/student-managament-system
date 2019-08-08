package com.denemeproje.demo2.controller;


import com.denemeproje.demo2.model.Courses;
import com.denemeproje.demo2.model.Student;
import com.denemeproje.demo2.services.CoursesService;
import com.denemeproje.demo2.services.StudentService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CoursesController {
    private CoursesService coursesService;
    private StudentService studentService;

    public CoursesController(CoursesService coursesService, StudentService studentService) {
        this.coursesService = coursesService;
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}/courses")
    public Set<Courses> getCoursesForStudent(@PathVariable Long id){
        Student s = studentService.getStudent(id);
        return s.getCourses();
    }

    @GetMapping("/students/{id}/courses/{courseId}")
    public Set<Courses> getCourse(@PathVariable Long id,@PathVariable Long courseId){
        Student s = studentService.getStudent(id);
        return s.getCourses();
    }

    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return coursesService.getCourses();
    }

    @PostMapping("/courses")
    public void addCourse(@RequestBody Courses course){
        coursesService.addCourse(course);
    }

    @PutMapping("/courses/{courseId}")
    public void updateCourse(@PathVariable Long id,@RequestBody Courses course,@PathVariable Long courseId){
        coursesService.updateCourse(course,courseId);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable Long courseId){
        coursesService.deleteCourse(courseId);
    }
}
