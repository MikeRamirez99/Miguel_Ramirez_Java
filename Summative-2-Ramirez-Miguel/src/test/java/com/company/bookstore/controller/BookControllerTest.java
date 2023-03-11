package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    // Test the creation of a new book
    @Test
    public void shouldReturnABookOnPostRequest() throws Exception {
        // ARRANGE
        Book book = new Book();
        book.setIsbn("9783161484100");
        book.setPublish_date(LocalDate.of(2015,8,1));
        book.setAuthor_id(1);
        book.setTitle("Dictionary");
        book.setPublisher_id(1);
        book.setPrice(BigDecimal.valueOf(19.99));

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(book);

        // ACT
        mockMvc.perform(
                        post("/book")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())
                .andExpect(status().isCreated());     // ASSERT (status code is 200)
    }

    // Testing to see if we can get a book by Id
    @Test
    public void shouldReturnABook() throws Exception {
        // Calling this on the first book in the database (Interesting book)

        // ACT
        mockMvc.perform(get("/book/1"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing Get All
    @Test
    public void shouldReturnAllBook() throws Exception {
        // Calling this on the first author in the database (Stephen King)

        // ACT
        mockMvc.perform(get("/book"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing Update
    @Test
    public void shouldUpdateById() throws Exception {
        // Giving it a customer and expecting no response
        Book book = new Book();
        book.setIsbn("9783161484100");
        book.setPublish_date(LocalDate.of(2015,8,1));
        book.setAuthor_id(1);
        book.setTitle("Dictionary");
        book.setPublisher_id(1);
        book.setPrice(BigDecimal.valueOf(19.99));

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(book);

        // ACT
        mockMvc.perform(
                        put("/book")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing delete
    @Test
    public void shouldDeleteById() throws Exception {
        // This method returns nothing, test deleting the first book and returning no content

        // ACT
        mockMvc.perform(delete("/book/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}