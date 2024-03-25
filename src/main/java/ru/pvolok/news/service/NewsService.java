package ru.pvolok.news.service;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import ru.pvolok.news.entity.NewsEntity;
import ru.pvolok.news.model.NewsDto;
import ru.pvolok.news.repository.NewsRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsDto getLastNews() {
        try {
            Document doc = Jsoup.connect("https://www.interfax.ru").get();
            String title = doc.select("body div.timeline > div:nth-child(1) a").attr("title");
            Long newsId = Long.valueOf(doc.select("body div.timeline > div:nth-child(1) a").attr("href").split("/")[2]);

            if (!newsRepository.findByNewsId(newsId).isPresent()) {
                NewsEntity newsEntity = new NewsEntity();
                newsEntity.setNewsId(newsId);
                newsEntity.setCapiton(title);

                newsRepository.save(newsEntity);
            }

            return new NewsDto(newsId, title, null);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<NewsDto> getAllNews() {
        return newsRepository.findAll()
                .stream()
                .map(newsEntity -> new NewsDto(newsEntity.getNewsId(), newsEntity.getCapiton(), null))
                .collect(Collectors.toList());
    }
}
