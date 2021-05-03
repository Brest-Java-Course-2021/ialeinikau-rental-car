package com.epam.brest.jdbc;

import com.epam.brest.dao.CarDao;
import com.epam.brest.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CarDaoJdbc implements CarDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(CarDaoJdbc.class);

    @Value("${car.findAll}")
    private String findAllSQL;

    @Value("${car.findById}")
    private String findByIdSql;

    @Value("${car.create}")
    private String createSQL;

    @Value("${car.update}")
    private String updateSQL;

    @Value("${car.delete}")
    private String deleteSQL;

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Car> findAll() {
        return namedParameterJdbcTemplate.query(findAllSQL, new CarRowMapper());
    }

    @Override
    public Optional<Car> findById(Integer carId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("CAR_ID" ,carId);
        List<Car> results = namedParameterJdbcTemplate.query(findByIdSql, sqlParameterSource, new CarRowMapper());
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    @Override
    public Integer create(Car car) {
        KeyHolder keyHolder =  new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("CAR_MODEL",car.getModelCar())
                .addValue("YEAR_OF_ISSUE",car.getYearOfIssue())
                .addValue("CAR_COLOR",car.getCarColor())
                .addValue("PRICE_PER_DAY",car.getPricePerDay())
                .addValue("LEASED",car.isLeased());
        namedParameterJdbcTemplate.update(createSQL,sqlParameterSource,keyHolder);
        return Objects.requireNonNull(keyHolder.getKey().intValue());
    }

    @Override
    public Integer update(Car car) {
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource()
                        .addValue("CAR_ID",car.getCarId())
                        .addValue("CAR_MODEL",car.getModelCar())
                        .addValue("YEAR_OF_ISSUE",car.getYearOfIssue())
                        .addValue("CAR_COLOR",car.getCarColor())
                        .addValue("PRICE_PER_DAY",car.getPricePerDay())
                        .addValue("LEASED",car.isLeased());
        return namedParameterJdbcTemplate.update(updateSQL, sqlParameterSource);
    }

    @Override
    public Integer delete(Integer carId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("CAR_ID", carId);
        Integer update = 0;
        try{
            return update = namedParameterJdbcTemplate.update(deleteSQL, sqlParameterSource);
        }catch (DataAccessException dataAccessException){
            LOGGER.warn("Can't delete Car,because car have dependencies ");
        }
        return update;
    }

    private class CarRowMapper implements RowMapper<Car>{

        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Car(
                    resultSet.getInt("CAR_ID"),
                    resultSet.getString("CAR_MODEL"),
                    resultSet.getInt("YEAR_OF_ISSUE"),
                    resultSet.getString("CAR_COLOR"),
                    resultSet.getDouble("PRICE_PER_DAY"),
                    resultSet.getBoolean("LEASED")
            );
        }
    }

}
