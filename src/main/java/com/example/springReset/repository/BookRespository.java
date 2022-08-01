package com.example.springReset.repository;

import com.example.springReset.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRespository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleContainingOrAuthorContaining(String text, String textAgain);

}