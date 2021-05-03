package com.epam.brest.service.rest;

import com.epam.brest.model.dto.CarDto;
import com.epam.brest.service.CarDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class CarDtoServiceRest  implements CarDtoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarDtoServiceRest.class);

    private final String url;

    private final RestTemplate restTemplate;

    public CarDtoServiceRest(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }
    @Override
    public List<CarDto> findAllQuantityOrders() {
        return restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<CarDto >>() {}).getBody();
    }
}
