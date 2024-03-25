package ru.pvolok.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pvolok.news.model.MessageDto;
import ru.pvolok.news.service.MessageService;

@RestController
public class MainController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public MessageDto getMessage() {
        return messageService.getMessage();
    }
}
