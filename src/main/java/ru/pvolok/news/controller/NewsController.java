package ru.pvolok.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pvolok.news.model.NewsDto;
import ru.pvolok.news.service.NewsService;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news/last")
    public NewsDto getLastNews() {
        return newsService.getLastNews();
    }

    @GetMapping("/news/all")
    public List<NewsDto> getAllNews() {
        return newsService.getAllNews();
    }
}
