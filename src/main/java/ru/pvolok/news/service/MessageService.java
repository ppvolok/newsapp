package ru.pvolok.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pvolok.news.component.IpAddressLoader;
import ru.pvolok.news.model.MessageDto;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final IpAddressLoader ipAddressLoader;

    public MessageDto getMessage() {
        return new MessageDto("Pavel", "Hello", ipAddressLoader.getIp());
    }
}
