package com.denemeproje.demo2.services;


import com.denemeproje.demo2.model.Courses;
import com.denemeproje.demo2.model.Student;
import com.denemeproje.demo2.repository.CoursesRepository;
import com.denemeproje.demo2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    CoursesRepository coursesRepository;
    StudentRepository studentRepository;

    public CoursesService(CoursesRepository coursesRepository, StudentRepository studentRepository) {
        this.coursesRepository = coursesRepository;
        this.studentRepository = studentRepository;
    }

    public List<Courses> getCourses(){
        return coursesRepository.findAll();
    }

    public Courses getCourse(Long id){
        return coursesRepository.findById(id).get();
    }

    public void addCourse(final Courses course){
        coursesRepository.save(course);
    }

    public void updateCourse(Courses courses,Long courseId){
        Long BodyId = courses.getId();

        if (BodyId == null){
            courses.setId(courseId);
            coursesRepository.save(courses);
        }else{
        }
    }

    public void deleteCourse(Long id){
        Courses willDelete = coursesRepository.findById(id).get();
        coursesRepository.delete(willDelete);
    }
}
