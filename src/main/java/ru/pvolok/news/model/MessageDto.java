package ru.pvolok.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDto {
    private String name;
    private String message;
    private String ip;
}
