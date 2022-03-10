package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    private long id;

    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}