package com.company.bookstore.repository;

import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
    //  No Non-standard commands required.
    //  As an API user, I would like to create, read, update, and delete books - Built-in
}
