package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    //  No Non-standard commands required.
    //  As an API user, I would like to create, read, update, and delete publishers - Built-in
}
