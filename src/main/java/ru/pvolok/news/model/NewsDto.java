package ru.pvolok.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsDto {
    private Long id;
    private String capiton;
    private String text;
}
