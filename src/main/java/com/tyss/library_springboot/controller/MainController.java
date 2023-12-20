package com.tyss.library_springboot.controller;

import com.tyss.library_springboot.entity.Book;
import com.tyss.library_springboot.structure.ResponseStructure;
import com.tyss.library_springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class MainController {
    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @GetMapping("/findbookbyid/{id}")
    public ResponseEntity<ResponseStructure<Book>> findBookById(@PathVariable int id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/deletebookbyid")
    public ResponseEntity<ResponseStructure<String>> deleteBookById(@RequestParam int id) {
        return bookService.deleteBookById(id);
    }

    @GetMapping("/findallbooks")
    public ResponseEntity<ResponseStructure<List<Book>>> findAllBooks() {
        return bookService.findAllBook();
    }

    @GetMapping("/findallbooksbyrating/{rating}")
    public ResponseEntity<ResponseStructure<List<Book>>> findBooksByRating(@PathVariable double rating) {
        return bookService.findBooksByRating(rating);
    }

    @GetMapping("/findallbookslessthanprice/{price}")
    public ResponseEntity<ResponseStructure<List<Book>>> findBooksLessThanPrice(@PathVariable double price) {
        return bookService.findBooksLessThanPrice(price);
    }

    @GetMapping("/findallbooksgreaterthanrating")
    public ResponseEntity<ResponseStructure<List<Book>>> findBooksGreaterThanRating(@RequestParam double rating) {
        return bookService.findBooksGreaterThanRating(rating);
    }


    @GetMapping("/findallbooksgreaterthanprice")
    public ResponseEntity<ResponseStructure<List<Book>>> findBooksGreaterThanPrice(@RequestParam double price) {
        return bookService.findBooksGreaterThanPrice(price);
    }

    @GetMapping("/findBookByName")
    public ResponseEntity<ResponseStructure<List<Book>>> findBookByName(@RequestParam String name) {
        return bookService.findBookByName(name);
    }


}
