package com.epam.brest.service.web_app.config;

import com.epam.brest.service.CarDtoService;
import com.epam.brest.service.CarOrderService;
import com.epam.brest.service.CarService;
import com.epam.brest.service.rest.CarDtoServiceRest;
import com.epam.brest.service.rest.CarOrderServiceRest;
import com.epam.brest.service.rest.CarServiceRest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {
    @Value("${rest.server.port}")
    private Integer port;

    @Value("${rest.server.url}")
    private String url;

    @Value("${rest.server.protocol}")
    private String protocol;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate(new SimpleClientHttpRequestFactory());
    }

    @Bean
    CarDtoService departmentDtoService() {
        return new CarDtoServiceRest(String.format("%s://%s:%d/blogs", protocol, url, port), getRestTemplate());
    };

    @Bean
    CarService carService() {
        return new CarServiceRest(String.format("%s://%s:%d/blogs", protocol, url, port), getRestTemplate());
    };

    @Bean
    CarOrderService carOrderService() {
        return new CarOrderServiceRest(String.format("%s://%s:%d/blogs", protocol, url, port), getRestTemplate());
    };
}
