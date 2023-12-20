package com.tyss.library_springboot.controller;

import com.tyss.library_springboot.dto.Book;
import com.tyss.library_springboot.entity.ResponseStructure;
import com.tyss.library_springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class MainController {
    @Autowired
    private BookService service;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @GetMapping("/findbookbyid/{id}")
    public ResponseEntity<ResponseStructure<Book>> findBookById(@PathVariable int id) {
        return service.findBookById(id);
    }

    @DeleteMapping("/deletebookbyid")
    public ResponseEntity<ResponseStructure<String>> deleteBookById(@RequestParam int id) {
        return service.deleteBookById(id);
    }

    @GetMapping("/findallbooks")
    public ResponseEntity<ResponseStructure<List<Book>>> findAllBooks() {
        return service.findAllBook();
    }

    @GetMapping("/findallbooksbyrating/{rating}")
    public ResponseEntity<ResponseStructure<List<Book>>> findBooksByRating(@PathVariable double rating) {
        return service.findBooksByRating(rating);
    }

    @GetMapping("/findallbookslessthanprice/{price}")
    public ResponseEntity<ResponseStructure<List<Book>>> findBooksLessThanPrice(@PathVariable double price) {
        return service.findBooksLessThanPrice(price);
    }

    @GetMapping("/findallbooksgreaterthanrating")
    public ResponseEntity<ResponseStructure<List<Book>>> findBooksGreaterThanRating(@RequestParam double rating) {
        return service.findBooksGreaterThanRating(rating);
    }


    @GetMapping("/findallbooksgreaterthanprice")
    public ResponseEntity<ResponseStructure<List<Book>>> findBooksGreaterThanPrice(@RequestParam double price) {
        return service.findBooksGreaterThanPrice(price);
    }

    @GetMapping("/findBookByName")
    public ResponseEntity<ResponseStructure<List<Book>>> findBookByName(@RequestParam String name) {
        return service.findBookByName(name);
    }


}
