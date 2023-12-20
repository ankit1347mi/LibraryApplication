package com.tyss.library_springboot.service;

import com.tyss.library_springboot.dto.Book;
import com.tyss.library_springboot.entity.ResponseStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    ResponseEntity<ResponseStructure<Book>> saveBook(Book book);

    ResponseEntity<ResponseStructure<Book>> updateBook(Book book);

    ResponseEntity<ResponseStructure<Book>> findBookById(int id);

    ResponseEntity<ResponseStructure<String>> deleteBookById(int id);

    ResponseEntity<ResponseStructure<List<Book>>> findAllBook();

    ResponseEntity<ResponseStructure<List<Book>>> findBooksByRating(double rating);

    ResponseEntity<ResponseStructure<List<Book>>> findBooksLessThanPrice(double price);

    ResponseEntity<ResponseStructure<List<Book>>> findBooksGreaterThanPrice(double price);

    ResponseEntity<ResponseStructure<List<Book>>> findBooksGreaterThanRating(double rating);

    ResponseEntity<ResponseStructure<List<Book>>> findBookByName(String name);
}
