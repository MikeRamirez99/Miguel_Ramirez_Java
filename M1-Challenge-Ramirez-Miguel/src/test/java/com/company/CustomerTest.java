package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    //Tests to make sure the balances add up
    @Test
    public void shouldReturnCorrectBalance() {
        int balancePiece = 500;
        int desiredBalance = balancePiece*2;
        Customer testCustomer = new Customer();
        AccountRecord newRecord = new AccountRecord();
        newRecord.setCharge(balancePiece);
        testCustomer.getCharges().add(newRecord);
        testCustomer.getCharges().add(newRecord);
        assertEquals(desiredBalance,testCustomer.getBalance());
    }

    //Tests to make sure that output contains the given name
    @Test
    public void shouldOutputToString() {
        String name = "JUnit";
        Customer testCustomer = new Customer();
        testCustomer.setId(255);
        testCustomer.setName(name);
        assertEquals(true,testCustomer.toString().contains(name));
    }
}