package ru.pvolok.news.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pvolok.news.entity.NewsEntity;
import ru.pvolok.news.model.NewsDto;
import ru.pvolok.news.repository.NewsRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public NewsDto getLastNews() {

        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.interfax.ru").get();
            String title = doc.select("body > main > div.mainblock > div > div.timeline > div:nth-child(1) a").attr("title");
            Long id = Long.valueOf(doc.select("body > main > div.mainblock > div > div.timeline > div:nth-child(1) a").attr("href").split("/")[2]);

            Boolean newsIsExists = newsRepository.findByNewsId(id).isPresent();

            if (!newsIsExists) {
                NewsEntity newsEntity = new NewsEntity();
                newsEntity.setNewsId(id);
                newsEntity.setCapiton(title);

                newsRepository.save(newsEntity);

                NewsDto news = new NewsDto(id, title, null);

                return news;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<NewsDto> getAllNews() {
        return newsRepository.findAll()
                .stream()
                .map(newsEntity -> new NewsDto(newsEntity.getNewsId(), newsEntity.getCapiton(), null))
                .collect(Collectors.toList());
    }
}
