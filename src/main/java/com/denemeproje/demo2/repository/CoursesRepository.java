package com.denemeproje.demo2.repository;

import com.denemeproje.demo2.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
    Courses findByCode(String code);
}
