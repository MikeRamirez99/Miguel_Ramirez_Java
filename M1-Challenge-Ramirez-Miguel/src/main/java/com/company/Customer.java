package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {

        //Return 0 if no entries present.
        if(charges.size() == 0)
        {
            return 0;
        }

        //Add up and return existing entries
        else
        {
            int runningCount = 0;
            for(AccountRecord entry:charges)
            {
                runningCount += entry.getCharge();
            }
            return runningCount;
        }
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //Combine user information into a single string, endline characters for readability
        String finalOutput = "";
        finalOutput += "Customer ID: " + id + "\r\n";
        finalOutput += "Customer Name: " + name + "\r\n";
        finalOutput += "Customer Balance: $" + getBalance() + "\r\n";
        return finalOutput;
    }
}
