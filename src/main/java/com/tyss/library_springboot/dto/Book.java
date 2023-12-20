package com.tyss.library_springboot.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "books")
@Data
public class Book {
    private int id;
    private String name;

    private String author;

    private double price;

    private double rating;
}
