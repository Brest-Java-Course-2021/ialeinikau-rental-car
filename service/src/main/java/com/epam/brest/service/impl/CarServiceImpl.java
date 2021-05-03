package com.epam.brest.service.impl;

import com.epam.brest.dao.CarDao;
import com.epam.brest.model.Car;
import com.epam.brest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Optional<Car> findById(Integer CarId) {
        return carDao.findById(CarId);
    }

    @Override
    public Integer create(Car Car) {
        return carDao.create(Car);
    }

    @Override
    public Integer update(Car Car) {
        return carDao.update(Car);
    }

    @Override
    public Integer delete(Integer carId) {
        return carDao.delete(carId);
    }
}
