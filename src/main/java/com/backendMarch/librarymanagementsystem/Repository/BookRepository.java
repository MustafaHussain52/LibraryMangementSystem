package com.backendMarch.librarymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backendMarch.librarymanagementsystem.Entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
