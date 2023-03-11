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
//import org.testing.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

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

    // Create Book
    @Test
    public void shouldCreateBook()
    {
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Hollywood");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostal_code("11100");
        author.setPhone("111-222-3333");
        author.setEmail("sking@gmail.com");

        //Act...
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        publisher = publisherRepo.save(publisher);

        //ARRANGE
        Book book = new Book();
        book.setIsbn("9783161484100");
        book.setPublish_date(LocalDate.of(2015,8,1));
        book.setAuthor_id(author.getId());
        book.setTitle("Dictionary");
        book.setPublisher_id(publisher.getId());
        book.setPrice(BigDecimal.valueOf(19.99));

        //ACT
        book = bookRepo.save(book);

        //ASSERT
        Optional<Book> bookTest = bookRepo.findById(book.getId());
        assertEquals(bookTest.get(),book);
    }

    @Test
    public void findBookById() {
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

        //Act...
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        publisher = publisherRepo.save(publisher);

        //ARRANGE
        Book book = new Book();
        book.setIsbn("9783161484100");
        book.setPublish_date(LocalDate.of(2015,8,1));
        book.setAuthor_id(author.getId());
        book.setTitle("Dictionary");
        book.setPublisher_id(publisher.getId());
        book.setPrice(BigDecimal.valueOf(19.99));

        //ACT
        book = bookRepo.save(book);

        //Assert...
        Optional<Book> bookTest = bookRepo.findById(book.getId());

        assertEquals(bookTest.get(),book);
    }

    @Test
    public void findAllBooks() {
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

        //Act...
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        publisher = publisherRepo.save(publisher);

        //ARRANGE
        Book book = new Book();
        book.setIsbn("9783161484100");
        book.setPublish_date(LocalDate.of(2015,8,1));
        book.setAuthor_id(author.getId());
        book.setTitle("Dictionary");
        book.setPublisher_id(publisher.getId());
        book.setPrice(BigDecimal.valueOf(19.99));

        //ACT
        book = bookRepo.save(book);

        Book book1 = new Book();
        book1.setIsbn("9783161484100");
        book1.setPublish_date(LocalDate.of(2015,8,1));
        book1.setAuthor_id(author.getId());
        book1.setTitle("Encyclopedia");
        book1.setPublisher_id(publisher.getId());
        book1.setPrice(BigDecimal.valueOf(19.99));

        //ACT
        book = bookRepo.save(book1);

        List<Book> bookList = bookRepo.findAll();

        //Assert...
        assertEquals(2, bookList.size());
    }

    @Test
    public void updateBook() {
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

        //Act...
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        publisher = publisherRepo.save(publisher);

        //ARRANGE
        Book book = new Book();
        book.setIsbn("9783161484100");
        book.setPublish_date(LocalDate.of(2015,8,1));
        book.setAuthor_id(author.getId());
        book.setTitle("Dictionary");
        book.setPublisher_id(publisher.getId());
        book.setPrice(BigDecimal.valueOf(19.99));

        //ACT
        book = bookRepo.save(book);

        //Act...
        book.setTitle("UPDATED");

        bookRepo.save(book);

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getId());

        assertEquals(book1.get(), book);
    }

    @Test
    public void deleteBook() {
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

        //Act...
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        publisher = publisherRepo.save(publisher);

        //ARRANGE
        Book book = new Book();
        book.setIsbn("9783161484100");
        book.setPublish_date(LocalDate.of(2015,8,1));
        book.setAuthor_id(author.getId());
        book.setTitle("Dictionary");
        book.setPublisher_id(publisher.getId());
        book.setPrice(BigDecimal.valueOf(19.99));

        //ACT
        book = bookRepo.save(book);

        //Act...
        bookRepo.deleteById(book.getId());

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getId());
        assertFalse(book1.isPresent());
    }
}