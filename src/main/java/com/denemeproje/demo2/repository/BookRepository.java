package com.denemeproje.demo2.repository;

import com.denemeproje.demo2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
}
