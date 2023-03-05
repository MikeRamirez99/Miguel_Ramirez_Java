package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
@Autowired
CustomerRepository repo;

    //POST route to create a new customer
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    //PUT route to update a customer that exists
    //I created this route based on class examples, however I think that an implementation
    //that uses /customers/{id} might be more useful since it would only update existing items.
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer)
    {
        repo.save(customer);
    }

    //DELETE route to delete a customer that exists
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id)
    {
        repo.deleteById(id);
    }

    //GET route to return a specific customer by ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getCustomerByID(@PathVariable int id){
        Optional<Customer> response = repo.findById(id);
        if(response.isPresent() == true){
            return response.get();
        }
        else {
            return null;
        }
    }

    //GET route to return a customer by a specific state.
    @RequestMapping(value = "/customers/state/{state}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getCustomersByState(@PathVariable String state){
        return repo.findByState(state);
    }
}
