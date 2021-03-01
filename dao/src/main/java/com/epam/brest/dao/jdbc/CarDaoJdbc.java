package com.epam.brest.dao.jdbc;

import com.epam.brest.dao.CarDao;
import com.epam.brest.model.Car;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarDaoJdbc implements CarDao {

    //TODO install H2 base
    private static final String SQL_GET_ALL_CAR ="SELECT C.CAR_ID, C.CAR_MODEL FROM CAR AS C ORDER BY C.CAR_MODEL";

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Car> findAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_CAR, new CarRowMapper());
    }


    //TODO car.set...
    private class CarRowMapper implements RowMapper<Car>{
        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car car = new Car();
            car.setCarId(resultSet.getInt("CAR_ID"));
            car.setModelCar(resultSet.getString("CAR_MODEL"));
            return car;
        }
    }
}
