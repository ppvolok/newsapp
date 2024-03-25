package ru.pvolok.news.component;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.pvolok.news.model.IpDto;

@Component
public class IpAddressLoader {


    public String getIp() {
        RestTemplate restTemplate = new RestTemplate();
        IpDto ipDto = restTemplate.getForObject("http://httpbin.org/ip", IpDto.class);

        return ipDto.getOrigin();
    }
}
