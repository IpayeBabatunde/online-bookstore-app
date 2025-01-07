package com.ipaye.onlinebookstoreapp.service;

import com.ipaye.onlinebookstoreapp.Repository.BookRepository;
import com.ipaye.onlinebookstoreapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBook(Long id){

        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
}
