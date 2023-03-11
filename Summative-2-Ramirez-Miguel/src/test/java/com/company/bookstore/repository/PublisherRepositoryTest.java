package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherRepositoryTest
{
    //Set up autowired
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

    // Create Publisher
    @Test
    public void shouldCreatePublisher()
    {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");
        publisher.setBooks(new HashSet<Book>());

        //ACT
        publisherRepo.save(publisher);

        //ASSERT
        Optional<Publisher> publisherTest = publisherRepo.findById(publisher.getId());
        assertEquals(publisherTest.get(),publisher);
    }

    // Read by Publisher ID
    @Test
    public void shouldReadPublisherByID()
    {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");
        publisher.setBooks(new HashSet<Book>());

        //ACT
        publisherRepo.save(publisher);

        //ASSERT
        Optional<Publisher> publisherTest = publisherRepo.findById(publisher.getId());
        assertEquals(publisherTest.get(),publisher);

    }

    // Read All Publishers
    @Test
    public void shouldReadAllPublishers()
    {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");
        publisher.setBooks(new HashSet<Book>());

        //ACT
        publisherRepo.save(publisher);

        //ASSERT
        List<Publisher> publisherTest = publisherRepo.findAll();
        assertEquals(publisherTest.size(),1);
    }

    // Update Publisher
    @Test
    public void shouldUpdatePublisher()
    {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");
        publisher.setBooks(new HashSet<Book>());

        //ACT
        publisherRepo.save(publisher);
        publisher.setName("New Management - TBA");
        publisherRepo.save(publisher);

        //ASSERT
        Optional<Publisher> publisherTest = publisherRepo.findById(publisher.getId());
        assertEquals(publisherTest.get(),publisher);
    }

    // Delete Publisher
    @Test
    public void shouldDeletePublisher()
    {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");
        publisher.setBooks(new HashSet<Book>());

        //ACT
        publisherRepo.save(publisher);
        publisherRepo.deleteById(publisher.getId());

        //ASSERT
        Optional<Publisher> publisherTest = publisherRepo.findById(publisher.getId());
        assertFalse(publisherTest.isPresent());
    }
}