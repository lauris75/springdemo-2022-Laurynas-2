package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, String> {

    List<Message> findAll();
}