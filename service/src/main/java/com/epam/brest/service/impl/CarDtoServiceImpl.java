package com.epam.brest.service.impl;

import com.epam.brest.model.dto.CarDto;
import com.epam.brest.service.CarDtoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarDtoServiceImpl implements CarDtoService {
    @Override
    public List<CarDto> findAllQuantityOrders() {
        return null;
    }
}
