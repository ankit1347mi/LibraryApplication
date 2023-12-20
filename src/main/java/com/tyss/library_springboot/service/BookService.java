package com.tyss.library_springboot.service;

import com.tyss.library_springboot.dao.BookDao;
import com.tyss.library_springboot.dto.Book;
import com.tyss.library_springboot.entity.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookDao dao;

    public ResponseEntity<ResponseStructure<Book>> saveBook(Book book) {
        Book book1 = dao.saveBook(book);
        ResponseStructure<Book> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Success");
        structure.setData(book1);

        return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Book>> updateBook(Book book) {
        Book book1 = dao.updateBook(book);
        ResponseStructure<Book> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(book1);

        return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<Book>> findBookById(int id) {
        Book book1 = dao.findBookById(id);
        ResponseStructure<Book> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.FOUND.value());
        structure.setMessage("Success");
        structure.setData(book1);

        return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<String>> deleteBookById(int id) {
        boolean result = dao.deleteBook(id);
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData("Book Removed Successfully");

        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<Book>>> findAllBook() {
        List<Book> result = dao.findAllBook();
        ResponseStructure<List<Book>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(result);

        return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<Book>>> findBooksByRating(double rating) {
        List<Book> result = dao.findBookByRating(rating);
        ResponseStructure<List<Book>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(result);

        return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<Book>>> findBooksLessThanPrice(double price) {
        List<Book> result = dao.findBookLessThanPrice(price);
        ResponseStructure<List<Book>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(result);

        return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<Book>>> findBooksGreaterThanPrice(double price) {
        List<Book> result = dao.findAllBook();
        List<Book> books = result.stream().filter(x -> x.getPrice() > price).toList();
        ResponseStructure<List<Book>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.FOUND.value());
        structure.setMessage("Success");
        structure.setData(books);

        return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<List<Book>>> findBooksGreaterThanRating(double rating) {
        List<Book> result = dao.findAllBook();
        List<Book> ratings = result.stream().filter(x -> x.getRating() > rating).toList();
        ResponseStructure<List<Book>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.FOUND.value());
        structure.setMessage("Success");
        structure.setData(ratings);

        return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.FOUND);
    }


    public ResponseEntity<ResponseStructure<List<Book>>> findBookByName(String name) {
        List<Book> result = dao.findBookByName(name);
        ResponseStructure<List<Book>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.FOUND.value());
        structure.setMessage("Success");
        structure.setData(result);
        return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.FOUND);
    }


}
