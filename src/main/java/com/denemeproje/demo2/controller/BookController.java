package com.denemeproje.demo2.controller;

import com.denemeproje.demo2.model.Book;
import com.denemeproje.demo2.model.Student;
import com.denemeproje.demo2.services.BookService;
import com.denemeproje.demo2.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class BookController  {

    private final BookService bookService;
    private final StudentService studentService;

    public BookController(BookService bookService, StudentService studentService) {
        this.bookService = bookService;
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}/books")
    public Set<Book> getBooks(@PathVariable Long id){
        Student s = studentService.getStudent(id);
        return s.getBooks();
    }

    @GetMapping("/students/{id}/books/{bookId}")
    public Book getBook(@PathVariable Long id,@PathVariable Long bookId){
        Student s = studentService.getStudent(id);
        return null;
    }

    @PostMapping("/students/{id}/books")
    public void addBook(@PathVariable Long id,@RequestBody Book book){
        bookService.addBook(book,id);
    }

    @PutMapping("/students/{id}/books/{bookId}")
    public void updateBook(@PathVariable Long id,@RequestBody Book book,@PathVariable Long bookId){
        bookService.updateBook(book,bookId);
    }

    @DeleteMapping("/students/{id}/books/{bookId}")
    public void deleteBook(@PathVariable Long id, @PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }


}
