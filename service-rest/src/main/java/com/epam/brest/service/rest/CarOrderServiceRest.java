package com.epam.brest.service.rest;



import com.epam.brest.model.CarOrder;
import com.epam.brest.service.CarOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CarOrderServiceRest implements CarOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceRest.class);

    private String url;
    private RestTemplate restTemplate;

    public CarOrderServiceRest(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CarOrder> findAll() {
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CarOrder>>() {
        }).getBody();
    }

    @Override
    public Optional<CarOrder> findById(Integer carOrderId) {
        return Optional.ofNullable(restTemplate.exchange(url + "/" + carOrderId,
                HttpMethod.GET, null, new ParameterizedTypeReference<CarOrder>() {
                }).getBody());
    }

    @Override
    public Integer create(CarOrder carOrder) {
        return restTemplate.postForEntity(url, carOrder, Integer.class).getBody();
    }

    @Override
    public Integer update(CarOrder carOrder) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<CarOrder> httpEntity = new HttpEntity<>(carOrder, headers);
        ResponseEntity<Integer> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Integer.class);
        return responseEntity.getBody();
    }

    @Override
    public Integer delete(Integer carOrderId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<CarOrder> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Integer> responseEntity = restTemplate.exchange(url + "/" + carOrderId, HttpMethod.DELETE, httpEntity, Integer.class);
        return responseEntity.getBody();
    }

    @Override
    public List<CarOrder> searchByTwoDates(LocalDate dateBefore, LocalDate dateAfter) {
        String dateBeforeString = dateBefore == null ? "" : dateBefore.toString();
        String dateAfterString = dateAfter == null ? "" : dateAfter.toString();

        String searchUrl = new StringBuilder(url)
                .append("/search?dateBefore=").append(dateBeforeString)
                .append("&dateAfter=").append(dateAfterString)
                .toString();
        return restTemplate.exchange(searchUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<CarOrder>>() {
        }).getBody();
    }
}
