package com.company.customerdataservice.repository;
import com.company.customerdataservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //Create a new customer record - built-in function, no extra implementation required.
    //Update an existing customer record - built-in function, no extra implementation required.
    //Delete an existing customer record - built-in function, no extra implementation required.
    //Find a customer record by id - built-in function, no extra implementation required.

    //Find by state function that allows us to search for an album by the state they reside.
    List<Customer> findByState(String state);
}
