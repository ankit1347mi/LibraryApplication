package com.tyss.library_springboot.repo;

import com.tyss.library_springboot.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepo extends MongoRepository<Book, Integer> {
        @Query("{rating:?0}")
        List<Book> findBookByRating(double rating);

        @Query("{price:{$lt:?0}}")
        List<Book> findBookLessThanPrice(double price);
}
