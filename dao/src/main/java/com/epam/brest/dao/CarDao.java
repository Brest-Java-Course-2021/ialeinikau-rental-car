package com.epam.brest.dao;

import com.epam.brest.model.Car;

import java.util.List;

public interface CarDao {

    List<Car> findAll();

}
