package com.epam.brest.service.rest;

import com.epam.brest.model.Car;
import com.epam.brest.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

public class CarServiceRest implements CarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceRest.class);

    private String url;
    private RestTemplate restTemplate;

    public CarServiceRest(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Car> findAll() {
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
        }).getBody();
    }

    @Override
    public Optional<Car> findById(Integer CarId) {
        return Optional.ofNullable(restTemplate.exchange(url + "/" + CarId,
                HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {
                }).getBody());
    }

    @Override
    public Integer create(Car Car) {
        return restTemplate.postForEntity(url, Car, Integer.class).getBody();
    }

    @Override
    public Integer update(Car Car) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Car> httpEntity = new HttpEntity<>(Car, headers);
        ResponseEntity<Integer> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Integer.class);
        return responseEntity.getBody();
    }

    @Override
    public Integer delete(Integer carId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Car> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Integer> responseEntity = restTemplate.exchange(url + "/" + carId, HttpMethod.DELETE, httpEntity, Integer.class);
        return responseEntity.getBody();
    }
}
