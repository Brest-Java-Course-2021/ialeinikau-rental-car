package com.epam.brest.service.impl;

import com.epam.brest.dao.CarOrderDao;
import com.epam.brest.model.CarOrder;
import com.epam.brest.service.CarOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarOrderServiceImpl implements CarOrderService {

    //TODO create and delete

    private final CarOrderDao carOrderDao;

    @Autowired
    public CarOrderServiceImpl(CarOrderDao carOrderDao) {
        this.carOrderDao = carOrderDao;
    }

    @Override
    public List<CarOrder> findAll() {
        return carOrderDao.findAll();
    }

    @Override
    public Optional<CarOrder> findById(Integer carOrderId) {
        return carOrderDao.findById(carOrderId);
    }

    @Override
    public Integer create(CarOrder carOrder) {
        return null;
    }

    @Override
    public Integer update(CarOrder carOrder) {
        return null;
    }

    @Override
    public Integer delete(Integer carOrderId) {
        return carOrderDao.delete(carOrderId);
    }
}
