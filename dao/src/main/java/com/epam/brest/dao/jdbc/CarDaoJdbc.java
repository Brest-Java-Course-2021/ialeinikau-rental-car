package com.epam.brest.dao.jdbc;

import com.epam.brest.dao.CarDao;
import com.epam.brest.model.Car;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;
import java.util.Objects;

public class CarDaoJdbc implements CarDao {

    //TODO install H2 base
    private static final String SQL_GET_ALL_CAR ="SELECT C.CAR_ID, C.CAR_MODEL FROM CAR AS C ORDER BY C.CAR_MODEL";
    private static final String SQL_GET_CAR_BY_ID ="SELECT C.CAR_ID, C.CAR_MODEL FROM CAR AS C WHERE C.CAR_ID = :CAR_ID";
    private static final String SQL_CREATE_CAR ="INSERT INTO CAR (CAR_MODEL) VALUES (:CAR_MODEL)";

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    RowMapper rowMapper = BeanPropertyRowMapper.newInstance(Car.class);

    public CarDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Car> findAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_CAR, rowMapper);
    }

    @Override
    public Car findById(Integer carId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("CAR_ID" ,carId);
        return (Car) namedParameterJdbcTemplate.query(SQL_GET_CAR_BY_ID,sqlParameterSource,rowMapper).get(0);
    }

    @Override
    public Integer create(Car car) {
        KeyHolder keyHolder =  new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("CAR_MODEL" ,car.getModelCar());
        namedParameterJdbcTemplate.update(SQL_CREATE_CAR,sqlParameterSource,keyHolder);
        return Objects.requireNonNull(keyHolder.getKey().intValue());
    }

    @Override
    public Integer update(Car car) {
        return null;
    }

    @Override
    public Integer delete(Integer carId) {
        return null;
    }

}
