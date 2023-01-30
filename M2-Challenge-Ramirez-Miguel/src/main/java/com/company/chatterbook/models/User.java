package com.company.chatterbook.models;

import java.util.*;

public class User {
    private String name;
    private List<ChatterPost> chatterPosts;

    //Constructor assigns given name
    public User(String name) {
        this.name = name;
    }

    //Standard get method
    public String getName() {
        return this.name;
    }

    //Standard set method
    public void setName(String name) {
        this.name = name;
    }

    //Standard get method
    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    //Standard set method
    public void setChatterPosts(List<ChatterPost> inputList) {
        this.chatterPosts = inputList;
    }
}
