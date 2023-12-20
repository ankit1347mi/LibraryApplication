package com.tyss.library_springboot.exception;

public class NoSuchBookFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "No Such Book Exists";
    }
}
