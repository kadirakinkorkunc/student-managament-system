package com.denemeproje.demo2.services;

import com.denemeproje.demo2.model.Book;
import com.denemeproje.demo2.model.Student;
import com.denemeproje.demo2.repository.BookRepository;
import com.denemeproje.demo2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public BookService(BookRepository bookRepository, StudentRepository studentRepository) {
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(Long id){
        return bookRepository.findById(id).get();
    }

    public void addBook(final Book book,Long id){
        Student s = studentRepository.findById(id).get();
        s.getBooks().add(book);
        studentRepository.save(s);
    }

    public void updateBook(Book book,Long bookId){
        Long BodyId = book.getId();
        if (BodyId == null){
            book.setId(bookId);
            bookRepository.save(book);
        }else{
        }
    }

    public void deleteBook(Long id){
        Book willDelete = bookRepository.findById(id).get();
        bookRepository.delete(willDelete);
    }
}
