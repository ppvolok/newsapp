package ru.pvolok.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pvolok.news.component.IpAddressLoader;
import ru.pvolok.news.model.MessageDto;

@Service
public class MessageService {

    @Autowired
    private IpAddressLoader ipAddressLoader;

    public MessageDto getMessage() {
        return new MessageDto("Pavel", "Hello", ipAddressLoader.getIp());
    }
}
