package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTests {

    @MockBean
    private AuthorRepository authorRepository;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    // Testing a post
    @Test
    public void shouldReturnAnAuthorOnPostRequest() throws Exception {
        // ARRANGE
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Hollywood");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostal_code("11100");
        author.setPhone("111-222-3333");
        author.setEmail("sking@gmail.com");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(author);

        // ACT
        mockMvc.perform(
                        post("/author")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())
                .andExpect(status().isCreated());     // ASSERT (status code is 200)
    }

    // Testing Get by Id
    @Test
    public void shouldReturnAnAuthor() throws Exception {
        // Calling this on the first author in the database (Stephen King)

        // ACT
        mockMvc.perform(get("/author/1"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing Get All
    @Test
    public void shouldReturnAllAuthors() throws Exception {
        // Calling this on the first author in the database (Stephen King)

        // ACT
        mockMvc.perform(get("/author"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing Update
    @Test
    public void shouldUpdateById() throws Exception {
        // Giving it a customer and expecting no response
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Hollywood");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostal_code("11100");
        author.setPhone("111-222-3333");
        author.setEmail("sking@gmail.com");

        String inputJson = mapper.writeValueAsString(author);

        // ACT
        mockMvc.perform(
                        put("/author")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    // Testing delete
    @Test
    public void shouldDeleteById() throws Exception {
        // This method returns nothing, test deleting the first author and returning no content

        // ACT
        mockMvc.perform(delete("/author/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
