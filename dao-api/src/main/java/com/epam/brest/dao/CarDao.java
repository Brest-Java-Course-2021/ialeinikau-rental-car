package com.epam.brest.dao;

import com.epam.brest.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> findAll();

    Optional<Car> findById(Integer carId);

    Integer create(Car car);

    Integer update(Car car);

    Integer delete(Integer carId);
}
