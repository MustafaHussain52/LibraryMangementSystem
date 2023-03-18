package com.backendMarch.librarymanagementsystem.Controller;

import com.backendMarch.librarymanagementsystem.DTO.BookRequestDto;
import com.backendMarch.librarymanagementsystem.DTO.BookResponseDto;
import com.backendMarch.librarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backendMarch.librarymanagementsystem.Entity.Book;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookservice;

    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {
//
//        try{
//            bookservice.addBook(book);
//        }
//        catch (Exception e){
//            throw new RuntimeException(e.getMessage()+"Book not added");
//        }
        //        return "Book added successfully";

     return bookservice.addBook(bookRequestDto);

    }
}
