package com.tyss.library_springboot.dao;

import com.tyss.library_springboot.entity.Book;

import java.util.List;

public interface BookDao {

    Book saveBook(Book book);

    Book updateBook(Book book);

    Book findBookById(int id);

    boolean deleteBook(int id);

    List<Book> findAllBook();

    List<Book> findBookByRating(double rating);

    List<Book> findBookLessThanPrice(double price);

    List<Book> findBookByName(String name);
}
