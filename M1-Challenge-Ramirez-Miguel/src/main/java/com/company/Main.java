package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Create Customer Database
        List<Customer> customerList = new ArrayList<>();

        //Iterate through input Data
        for (String[] customerInput:customerData){

            //Create new record value
            AccountRecord newRecord = new AccountRecord();
            newRecord.setCharge(Integer.parseInt(customerInput[2]));
            newRecord.setChargeDate(customerInput[3]);

            //Check for presence of customer
            boolean customerPresent = false;
            for(Customer i:customerList){

                //If found, add record
                if (i.getId() == Integer.parseInt(customerInput[0]))
                {

                    i.getCharges().add(newRecord);
                    customerPresent = true;
                }
            }

            //If customer not present, add to list
            if (customerPresent == false) {
                Customer newCustomer = new Customer();
                newCustomer.setId(Integer.parseInt(customerInput[0]));
                newCustomer.setName(customerInput[1]);
                newCustomer.getCharges().add(newRecord);
                customerList.add(newCustomer);
            }
        }

        System.out.println("Positive accounts:");
        //Return accounts with a balance higher or equal to 0 (positive)
        for(Customer i:customerList)
        {
            if(i.getBalance()>=0)
            {
                System.out.println(i.toString());
            }
        }

        System.out.println("Negative accounts:");
        //Return accounts with a balance lower to 0 (negative)
        for(Customer i:customerList)
        {
            if(i.getBalance()<0)
            {
                System.out.println(i.toString());
            }
        }
    }
}
