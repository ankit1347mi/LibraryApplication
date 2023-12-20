package com.tyss.library_springboot.dao;

import com.tyss.library_springboot.dto.Book;
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
public class BookDao {
    @Autowired
    private BookRepo repo;
    @Autowired
    private MongoTemplate template;


    public Book saveBook(Book book) {
        Book book1 = repo.save(book);
        return book1;
    }

    public Book updateBook(Book book) {
        Optional<Book> book1 = repo.findById(book.getId());
        if (book1.isPresent()) {
            return repo.save(book);
        }
        throw new NoSuchBookFoundException();
    }

    public Book findBookById(int id) {
        Optional<Book> book = repo.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        throw new NoSuchBookFoundException();
    }

    public boolean deleteBook(int id) {
        Optional<Book> book = repo.findById(id);
        if (book.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Book> findAllBook() {
        List<Book> books = repo.findAll();
        if (!books.isEmpty()) {
            return books;
        }
        throw new NoSuchBookFoundException();
    }

    public List<Book> findBookByRating(double rating) {
        List<Book> books = repo.findBookByRating(rating);
        if (!books.isEmpty()) {
            return books;
        }
        throw new NoSuchBookFoundException();
    }

    public List<Book> findBookLessThanPrice(double price) {
        List<Book> books = repo.findBookLessThanPrice(price);
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
