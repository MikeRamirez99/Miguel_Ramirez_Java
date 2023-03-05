package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepo;

    //Makes sure repo is empty.
    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    //Inserts a customer into the DB and checks for its presence.
    @Test
    public void shouldCreateCustomerRecord()
    {
        //Create Object
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");
        customerRepo.save(insertCustomer);

        //Check DB
        Optional<Customer> customerCheck = customerRepo.findById(insertCustomer.getId());

        //Confirm and Assert
        assertEquals(customerCheck.get(),insertCustomer);

    }

    //Insert a customer, modify customer data and check for updated info.
    @Test
    public void shouldUpdateExistingCustomerRecord()
    {
        //Create Object
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");
        customerRepo.save(insertCustomer);

        //Modify Object and Update DB
        insertCustomer.setFirst_name("James");
        insertCustomer.setFirst_name("Smith");
        customerRepo.save(insertCustomer);

        //Check DB
        Optional<Customer> customerCheck = customerRepo.findById(insertCustomer.getId());

        //Confirm and Assert
        assertEquals(customerCheck.get(),insertCustomer);

    }

    //Create customer, delete customer then check for absence.
    @Test
    public void shouldDeleteExistingCustomerRecordByID()
    {
        //Create Object
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");
        customerRepo.save(insertCustomer);

        //Check DB
        Optional<Customer> customerCheck = customerRepo.findById(insertCustomer.getId());

        //Confirm and Assert
        assertEquals(customerCheck.get(),insertCustomer);

        //Delete from DB
        customerRepo.deleteById(insertCustomer.getId());

        //Check if customer is present
        Optional<Customer> customerExist = customerRepo.findById(insertCustomer.getId());
        assertFalse(customerExist.isPresent());


    }

    //Creates 2 customer objects, then checks for DB size to be >1 and for customer1 to be present.
    @Test
    public void shouldFindCustomerRecordByID()
    {
        //Create First Object
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");
        customerRepo.save(insertCustomer);

        //Create Customer Object
        Customer insertCustomer2 = new Customer();
        insertCustomer2.setFirst_name("Jill");
        insertCustomer2.setFirst_name("Jameson");
        customerRepo.save(insertCustomer2);

        //Check DB
        Optional<Customer> customerCheck = customerRepo.findById(insertCustomer.getId());
        List<Customer> customerList = customerRepo.findAll();

        //Confirm more than one customer in DB and check for desired Customer
        assertEquals(customerList.size(),2);
        assertEquals(customerCheck.get(),insertCustomer);
    }

    //Create 2 customer object, check that there is 1 customer in TX and that their label is TX
    @Test
    public void shouldFindCustomerRecordByState()
    {
        //Create First Object
        Customer insertCustomer = new Customer();
        insertCustomer.setFirst_name("Jake");
        insertCustomer.setFirst_name("Perez");
        insertCustomer.setState("TX");
        customerRepo.save(insertCustomer);

        //Create Customer Object
        Customer insertCustomer2 = new Customer();
        insertCustomer2.setFirst_name("Jill");
        insertCustomer2.setFirst_name("Jameson");
        insertCustomer2.setState("LA");
        customerRepo.save(insertCustomer2);

        //Check DB
        List<Customer> customerList = customerRepo.findByState("TX");

        //Assert that there is one customer in TX and their label is TX
        assertEquals(customerList.size(),1);
        assertEquals(customerList.get(0).getState(),"TX");
    }
}