package com.denemeproje.demo2.services;


import com.denemeproje.demo2.model.Courses;
import com.denemeproje.demo2.model.Student;
import com.denemeproje.demo2.repository.CoursesRepository;
import com.denemeproje.demo2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private CoursesRepository coursesRepository;

    public StudentService(StudentRepository studentRepository, CoursesRepository coursesRepository) {
        this.studentRepository = studentRepository;
        this.coursesRepository = coursesRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id).get();
    }

    public Student addStudent(final Student book){
        return studentRepository.save(book);
    }

    public void updateStudent(Student student, Long id){
        Long BodyId = student.getId();
        if (BodyId == null){
            student.setId(id);
            studentRepository.save(student);
        }else{
        }



    }

    public void deleteStudent(Long id){
        Student willDelete = studentRepository.findById(id).get();
        studentRepository.delete(willDelete);
    }

    public void enroll(Long studentId,String courseCode){
        Student studentFromDB = studentRepository.findById(studentId).get();
        Courses courseFromDB = coursesRepository.findByCode(courseCode);

        if(studentFromDB !=null && courseFromDB != null){
            studentFromDB.getCourses().add(courseFromDB);
            studentRepository.save(studentFromDB);
        }
    }
}
