package com.epam.brest.service;

import com.epam.brest.model.CarOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarOrderService {
    List<CarOrder> findAll();

    Optional<CarOrder> findById(Integer carOrderId);

    Integer create(CarOrder carOrder);

    Integer update(CarOrder carOrder);

    Integer delete(Integer carOrderId);

    List<CarOrder> searchByTwoDates(LocalDate dateBefore, LocalDate dateAfter);
}
