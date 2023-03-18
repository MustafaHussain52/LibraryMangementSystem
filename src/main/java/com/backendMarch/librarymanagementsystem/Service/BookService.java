package com.backendMarch.librarymanagementsystem.Service;

import com.backendMarch.librarymanagementsystem.DTO.BookRequestDto;
import com.backendMarch.librarymanagementsystem.DTO.BookResponseDto;
import com.backendMarch.librarymanagementsystem.Entity.Author;
import com.backendMarch.librarymanagementsystem.Repository.AuthorRepository;
import com.backendMarch.librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backendMarch.librarymanagementsystem.Entity.Book;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws Exception {
//
//        Author author;
//        try {
//             author = authorRepository.findById(book.getAuthor().getId()).get();
//        } catch (Exception e) {
//            throw new Exception("Author not present");
//        }
//        List<Book> bookWritten = author.getBooks();
//        bookWritten.add(book);
//
//        authorRepository.save(author);

        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        Book book = new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIssued(false);
        book.setAuthor(author);

        author.getBooks().add(book);
        authorRepository.save(author);

        //create a response
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());
        return bookResponseDto;


    }
}
