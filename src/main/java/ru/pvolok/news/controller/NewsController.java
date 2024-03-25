package ru.pvolok.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pvolok.news.model.NewsDto;
import ru.pvolok.news.service.NewsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news/last")
    public NewsDto getLastNews() {
        return newsService.getLastNews();
    }

    @GetMapping("/news/all")
    public List<NewsDto> getAllNews() {
        return newsService.getAllNews();
    }
}
