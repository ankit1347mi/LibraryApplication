package com.tyss.library_springboot.dao.impl;

import com.tyss.library_springboot.dao.BookDao;
import com.tyss.library_springboot.entity.Book;
import com.tyss.library_springboot.exception.NoSuchBookFoundException;
import com.tyss.library_springboot.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private MongoTemplate template;


    public Book saveBook(Book book) {
        Book book1 = bookRepo.save(book);
        return book1;
    }

    public Book updateBook(Book book) {
        Optional<Book> book1 = bookRepo.findById(book.getId());
        if (book1.isPresent()) {
            return bookRepo.save(book);
        }
        throw new NoSuchBookFoundException();
    }

    public Book findBookById(int id) {
        Optional<Book> book = bookRepo.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        throw new NoSuchBookFoundException();
    }

    public boolean deleteBook(int id) {
        Optional<Book> book = bookRepo.findById(id);
        if (book.isPresent()) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Book> findAllBook() {
        List<Book> books = bookRepo.findAll();
        if (!books.isEmpty()) {
            return books;
        }
        throw new NoSuchBookFoundException();
    }

    public List<Book> findBookByRating(double rating) {
        List<Book> books = bookRepo.findBookByRating(rating);
        if (!books.isEmpty()) {
            return books;
        }
        throw new NoSuchBookFoundException();
    }

    public List<Book> findBookLessThanPrice(double price) {
        List<Book> books = bookRepo.findBookLessThanPrice(price);
        if (!books.isEmpty()) {
            return books;
        }
        throw new NoSuchBookFoundException();
    }

    public List<Book> findBookByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return template.find(query, Book.class);

    }
}
