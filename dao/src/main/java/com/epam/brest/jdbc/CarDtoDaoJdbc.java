package com.epam.brest.jdbc;

import com.epam.brest.dao.CarDtoDao;
import com.epam.brest.model.dto.CarDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CarDtoDaoJdbc implements CarDtoDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarDtoDaoJdbc.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarDtoDaoJdbc(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Value("${carDto.findAllQuantityOrders}")
    private String findAllQuantityOrders;

    @Override
    public List<CarDto> findAllQuantityOrders() {
        List<CarDto> cars = namedParameterJdbcTemplate.query(findAllQuantityOrders,
                BeanPropertyRowMapper.newInstance(CarDto.class));
        return cars;
    }
}
