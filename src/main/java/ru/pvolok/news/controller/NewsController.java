package ru.pvolok.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pvolok.news.exception.InterfaxNotAvailableException;
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

    @ExceptionHandler(InterfaxNotAvailableException.class)
    public ResponseEntity handleInterfaxNotAvailableException(InterfaxNotAvailableException e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}
