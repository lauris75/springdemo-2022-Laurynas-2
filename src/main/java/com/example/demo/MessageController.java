package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    public static final String BE_SUCCESS_MESSAGE = "BE works ";
    public static final String DB_SUCCESS_MESSAGE = "DB success message: ";
    public static final String DB_ERROR_MESSAGE = "DB error message ";

    @Autowired
    MessageRepository repo;

    @GetMapping(value = "/")
    public String getMessage() {
        StringBuilder result = new StringBuilder(BE_SUCCESS_MESSAGE);

        try {
            List<Message> messages = repo.findAll();
            Optional<Message> message = messages.stream().findFirst();
            message.ifPresent(value -> result.append(DB_SUCCESS_MESSAGE).append(value.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            result.append(DB_ERROR_MESSAGE).append(e.getMessage());
        }

        return result.toString();
    }

    @GetMapping(value = "/message/{message}")
    public void saveMessage(@PathVariable String message) {
        repo.save(new Message(message));
    }
}
