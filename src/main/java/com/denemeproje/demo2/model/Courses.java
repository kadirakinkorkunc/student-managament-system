package com.denemeproje.demo2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String code;
    private String instructor;

    @JsonBackReference
    // bunun ile loop önlenebiliyor fakat bu sefer kursu hangi ogrencılerın aldıgı gozukmuyor
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
