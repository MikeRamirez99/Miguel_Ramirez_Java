package com.company.bookstore.controller;
import com.company.bookstore.model.Book;

import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    // Autowire the Repo
    @Autowired
    BookRepository repo;

    // POST route to create a Book
    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book)
    {
        return repo.save(book);
    }

    // GET route to read a Book by ID
    @GetMapping("/book/{id}")
    public Book getBookByID(@PathVariable int id)
    {
        Optional<Book> response = repo.findById(id);
        //If publisher not found, return null
        if(response.isPresent() == true){
            return response.get();
        }
        else {
            return null;
        }
    }

    // GET route to read all Books
    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    // PUT route to update a Book
    @PutMapping("/book")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book)
    {
        repo.save(book);
    }

    // DELETE route to delete a Book by ID
    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id)
    {
        repo.deleteById(id);
    }

}
