package com.epam.brest.dao;


import com.epam.brest.model.CarOrder;

import java.util.List;
import java.util.Optional;

public interface CarOrderDao {
    List<CarOrder> findAll();

    Optional<CarOrder> findById(Integer carOrderId);

    Integer create(CarOrder carOrder);

    Integer update(CarOrder carOrder);

    Integer delete(Integer carOrderId);
}
