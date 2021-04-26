package com.epam.brest.service;

import com.epam.brest.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();

    Optional<Car> findById(Integer CarId);

    Integer create(Car Car);

    Integer update(Car Car);

    Integer delete(Integer carId);
}
