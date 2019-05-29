package com.renanparis.chat.model;

public class Posts {

    private String text;
    private int id;



    public Posts(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
