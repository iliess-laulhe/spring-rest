package com.example.springReset.controller;

import com.example.springReset.entity.Book;
import com.example.springReset.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookRespository bookRespository;

    @GetMapping("/books")
    public List<Book> index(){
        return bookRespository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable int id){
        return bookRespository.findById(id).get();
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRespository.findByTitleContainingOrAuthorContaining(searchTerm, searchTerm);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRespository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){
        // getting blog
        Book blogToUpdate = bookRespository.findById(id).get();
        blogToUpdate.setTitle(book.getTitle());
        blogToUpdate.setAuthor(book.getAuthor());
        return bookRespository.save(blogToUpdate);
    }

    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable int id){
        bookRespository.deleteById(id);
        return true;
    }
}