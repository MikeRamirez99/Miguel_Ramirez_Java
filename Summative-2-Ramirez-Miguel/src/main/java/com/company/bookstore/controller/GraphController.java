package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @QueryMapping
    public Book findBookById(@Argument String id) {
        Optional<Book> b = bookRepository.findById(Integer.parseInt(id));
        if (b.isPresent()) {
            return b.get();
        } else {
            return null;
        }
    }

    @QueryMapping
    public Author findAuthorById(@Argument String id) {
        Optional<Author> a = authorRepository.findById(Integer.parseInt(id));
        if (a.isPresent()) {
            return a.get();
        } else {
            return null;
        }
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument String id) {
        Optional<Publisher> p = publisherRepository.findById(Integer.parseInt(id));
        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }
    }
}
