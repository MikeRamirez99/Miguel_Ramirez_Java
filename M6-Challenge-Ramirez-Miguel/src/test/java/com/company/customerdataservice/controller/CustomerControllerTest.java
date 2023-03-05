package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
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
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    //Standard MockMVC Initializers, setUp() not required due to MockMVC
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    //Communication with Customer Repository
    @MockBean
    private CustomerRepository customerRepo;

    //Test POST route to create a new customer.
    @Test
    public void shouldCreateNewCustomer() throws Exception {
        //Create customer to be inserted
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");

        //Converts customer into JSON
        String inputJson = mapper.writeValueAsString(insertCustomer);

        //Insert customer into DB via REST and check for correct Status Code
        mockMvc.perform(
                post("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    //Test PUT route to update customer
    @Test
    public void shouldModifyExistingCustomer() throws Exception {
        //Create customer to be inserted
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");

        //Converts customer into JSON
        String inputJson = mapper.writeValueAsString(insertCustomer);

        //Insert customer into DB via REST
        mockMvc.perform(
                        post("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                );

        //Modify customer input
        insertCustomer.setFirst_name("John");
        insertCustomer.setFirst_name("Smith");
        inputJson = mapper.writeValueAsString(insertCustomer);

        //Modify customer in DB and check for correct Status Code
        mockMvc.perform(
                        put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //Test DELETE route to delete existing customer
    @Test
    public void shouldReturnDeleteStatusCode() throws Exception {
        //Attempt to delete non-existent customer and return status code
        mockMvc.perform(
                        delete("/customers/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //Test GET route to return a specific customer by ID
    @Test
    public void shouldGetSpecificCustomerByID() throws Exception {
        //Create customer to be inserted
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");
        insertCustomer.setId(22);

        //Converts customer into JSON
        String javaJSON = mapper.writeValueAsString(insertCustomer);

        //Insert customer into DB via REST
        mockMvc.perform(
                put("/customers")
                        .content(javaJSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        //Get customer via REST and check for correct Status Code
        mockMvc.perform(
                        get("/customers/22"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //Test GET route to return all customers for a specific state
    @Test
    public void shouldGetCustomersByState() throws Exception {
        //Create customer to be inserted
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");
        insertCustomer.setState("TX");

        //Converts customer into JSON
        String javaJSON = mapper.writeValueAsString(insertCustomer);

        //Insert customer into DB via REST
        mockMvc.perform(
                put("/customers")
                        .content(javaJSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        //Get customer via REST and check for correct Status Code
        mockMvc.perform(
                        get("/customers/state/TX"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}