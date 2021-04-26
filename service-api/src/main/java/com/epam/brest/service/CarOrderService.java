package com.epam.brest.service;

import com.epam.brest.model.CarOrder;

import java.util.List;
import java.util.Optional;

public interface CarOrderService {
    List<CarOrder> findAll();

    Optional<CarOrder> findById(Integer carOrderId);

    Integer create(CarOrder carOrder);

    Integer update(CarOrder carOrder);

    Integer delete(Integer carOrderId);
}
