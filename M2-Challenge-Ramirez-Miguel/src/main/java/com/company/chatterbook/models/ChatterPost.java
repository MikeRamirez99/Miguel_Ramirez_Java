package com.company.chatterbook.models;

public class ChatterPost {
    private String text;

    //Constructor that assigns text to ChatterPost
    public ChatterPost(String text) {
        this.text = text;
    }

    //Standard get method
    public String getText() {
        return text;
    }

    //Standard set method
    public void setText(String text) {
        this.text = text;
    }
}
