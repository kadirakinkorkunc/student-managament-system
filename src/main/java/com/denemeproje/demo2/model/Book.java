package com.denemeproje.demo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String author;
        private String name;
        private LocalDateTime publishDate;
        private String isbnNumber;
}
