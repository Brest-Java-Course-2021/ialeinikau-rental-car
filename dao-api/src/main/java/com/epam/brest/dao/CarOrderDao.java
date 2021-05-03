package com.epam.brest.dao;


import com.epam.brest.model.CarOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarOrderDao {
    List<CarOrder> findAll();

    Optional<CarOrder> findById(Integer carOrderId);

    Integer create(CarOrder carOrder);

    Integer update(CarOrder carOrder);

    Integer delete(Integer carOrderId);

    List<CarOrder> searchByTwoDates(LocalDate dateBefore, LocalDate dateAfter);
}
