package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTests {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception {
        bookRepo.deleteAll();
        publisherRepo.deleteAll();
        authorRepo.deleteAll();
    }

    @Test
    public void addAuthor() {
        //Arrange...
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Hollywood");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostal_code("11100");
        author.setPhone("111-222-3333");
        author.setEmail("sking@gmail.com");
        author.setBooks(new HashSet<Book>());

        //Act...
        author = authorRepo.save(author);

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void findAuthorById() {
        //Arrange...
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Hollywood");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostal_code("11100");
        author.setPhone("111-222-3333");
        author.setEmail("sking@gmail.com");
        author.setBooks(new HashSet<Book>());

        authorRepo.save(author);

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void findAllAuthors() {
        //Arrange...
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Hollywood");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostal_code("11100");
        author.setPhone("111-222-3333");
        author.setEmail("sking@gmail.com");
        author.setBooks(new HashSet<Book>());

        authorRepo.save(author);

        Author author2 = new Author();
        author2.setFirst_name("William");
        author2.setLast_name("Shakespeare");
        author2.setStreet("Hollywood");
        author2.setCity("Los Angeles");
        author2.setState("CA");
        author2.setPostal_code("11100");
        author2.setPhone("111-222-3333");
        author2.setEmail("sking@gmail.com");
        author.setBooks(new HashSet<Book>());

        authorRepo.save(author2);

        List<Author> authorList = authorRepo.findAll();

        //Assert...
        assertEquals(2, authorList.size());
    }

    @Test
    public void updateAuthor() {
        //Arrange...
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Hollywood");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostal_code("11100");
        author.setPhone("111-222-3333");
        author.setEmail("sking@gmail.com");
        author.setBooks(new HashSet<Book>());

        authorRepo.save(author);

        //Act...
        author.setFirst_name("UPDATED");

        authorRepo.save(author);

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void deleteAuthor() {
        //Arrange...
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Hollywood");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostal_code("11100");
        author.setPhone("111-222-3333");
        author.setEmail("sking@gmail.com");
        author.setBooks(new HashSet<Book>());

        authorRepo.save(author);

        //Act...
        authorRepo.deleteById(author.getId());

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getId());
        assertFalse(author1.isPresent());
    }
}
