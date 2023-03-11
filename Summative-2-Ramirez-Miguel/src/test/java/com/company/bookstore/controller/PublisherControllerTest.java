package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.company.bookstore.repository.PublisherRepository;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {

    // Testing Set-up
    @MockBean
    private PublisherRepository publisherRepo;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    // POST route to create a publisher
    @Test
    public void shouldCreatePublisherViaRESTRoute() throws Exception {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        //ACT
        String inJson = mapper.writeValueAsString(publisher);
        mockMvc.perform(post("/publisher")
                .content(inJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated()); //Assert

    }
    // GET route to read publisher by ID
    @Test
    public void shouldReadPublisherByIDViaRESTRoute() throws Exception {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        //ACT
        String inJson = mapper.writeValueAsString(publisher);
        mockMvc.perform(get("/publisher/1")
                        .content(inJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()); //Assert
    }
    // GET route to read all publishers
    @Test
    public void shouldReadAllPublishersViaRESTRoute() throws Exception {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        //ACT
        String inJson = mapper.writeValueAsString(publisher);
        mockMvc.perform(get("/publisher")
                        .content(inJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()); //Assert
    }
    // PUT route to update publisher
    @Test
    public void shouldUpdatePublisherViaRESTRoute() throws Exception {
        //ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("10019");
        publisher.setPhone("212-782-9000");
        publisher.setEmail("penguinrandomhouse@penguinrandomhouse.com");

        //ACT
        String inJson = mapper.writeValueAsString(publisher);
        mockMvc.perform(put("/publisher")
                        .content(inJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent()); //Assert
    }
    // DELETE route to remove publisher by ID
    @Test
    public void shouldRemovePublisherByIDViaRESTRoute() throws Exception {
        //ACT
        mockMvc.perform(delete("/publisher/1"))
                .andDo(print())
                .andExpect(status().isNoContent()); //Assert
    }
}