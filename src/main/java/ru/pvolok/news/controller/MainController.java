package ru.pvolok.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pvolok.news.model.MessageDto;
import ru.pvolok.news.service.MessageService;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MessageService messageService;

    @GetMapping("/message")
    public MessageDto getMessage() {
        return messageService.getMessage();
    }
}
