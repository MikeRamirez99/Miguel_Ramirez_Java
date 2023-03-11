package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository repo;

    // Read by ID
    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable int id) {
        Optional<Author> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Read All
    @GetMapping("/author")
    public List<Author> getAuthors() {
        return repo.findAll();
    }

    // Create
    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        return repo.save(author);
    }

    // Update
    @PutMapping("/author")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author) {
        repo.save(author);
    }

    // Delete
    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        repo.deleteById(id);
    }
}
