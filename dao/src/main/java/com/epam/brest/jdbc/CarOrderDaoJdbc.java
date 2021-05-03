package com.epam.brest.jdbc;

import com.epam.brest.dao.CarOrderDao;
import com.epam.brest.model.CarOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
import java.time.LocalDate;
import java.util.*;

@Repository
public class CarOrderDaoJdbc implements CarOrderDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(CarDaoJdbc.class);

    @Value("${carOrder.findAll}")
    private String findAllSQL;

    @Value("${carOrder.findById}")
    private String findByIdSql;

    @Value("${carOrder.create}")
    private String createSQL;

    @Value("${carOrder.update}")
    private String updateSQL;

    @Value("${carOrder.delete}")
    private String deleteSQL;

    @Value("${carOrder.searchByDate}")
    private String searchByDate;

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarOrderDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<CarOrder> findAll() {
        return namedParameterJdbcTemplate.query(findAllSQL, new CarOrderRowMapper());
    }

    @Override
    public Optional<CarOrder> findById(Integer carOrderId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("CAR_ORDER_ID" ,carOrderId);
        List<CarOrder> results = namedParameterJdbcTemplate.query(findByIdSql, sqlParameterSource, new CarOrderRowMapper());
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    @Override
    public Integer create(CarOrder carOrder) {
        KeyHolder keyHolder =  new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("RENTERS_NAME",carOrder.getRentersName())
                .addValue("DATE_LEASED",carOrder.getDateLeased())
                .addValue("RENT_STATUS",carOrder.getOrderId())
                .addValue("CAR_REPAIR_BILL",carOrder.getCarRepairBill())
                .addValue("INFO_ABOUT_DAMAGE",carOrder.getInformationAboutDamage())
                .addValue("REJECTION_REASON",carOrder.getRejectionReason())
                .addValue("CAR_ID",carOrder.getCarId());
        namedParameterJdbcTemplate.update(createSQL,sqlParameterSource,keyHolder);
        return Objects.requireNonNull(keyHolder.getKey().intValue());
    }

    @Override
    public Integer update(CarOrder carOrder) {
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource()
                        .addValue("CAR_ORDER_ID",carOrder.getOrderId())
                        .addValue("RENTERS_NAME",carOrder.getRentersName())
                        .addValue("DATE_LEASED",carOrder.getDateLeased())
                        .addValue("RENT_STATUS",carOrder.getOrderId())
                        .addValue("CAR_REPAIR_BILL",carOrder.getCarRepairBill())
                        .addValue("INFO_ABOUT_DAMAGE",carOrder.getInformationAboutDamage())
                        .addValue("REJECTION_REASON",carOrder.getRejectionReason())
                        .addValue("CAR_ID",carOrder.getCarId());
        return namedParameterJdbcTemplate.update(updateSQL, sqlParameterSource);
    }

    @Override
    public Integer delete(Integer carOrderId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("CAR_ORDER_ID", carOrderId);
        return namedParameterJdbcTemplate.update(deleteSQL, sqlParameterSource);
    }

    @Override
    public List<CarOrder> searchByTwoDates(LocalDate dateBefore, LocalDate dateAfter) {
        if (dateAfter.isBefore(dateBefore)) {
            LOGGER.warn("searchByTwoDates() throw IllegalArgumentException because Date After should be later than date before");
            throw new IllegalArgumentException("Date After should be later than date before");
        }
        Map<String, Object> parametrizedValues = new HashMap<>();
        parametrizedValues.put("DATE_BEFORE", dateBefore);
        parametrizedValues.put("DATE_AFTER", dateAfter);
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parametrizedValues);
        return namedParameterJdbcTemplate.query(searchByDate, sqlParameterSource, new CarOrderRowMapper());
    }

    private class CarOrderRowMapper implements RowMapper<CarOrder> {

        @Override
        public CarOrder mapRow(ResultSet resultSet, int i) throws SQLException {
            return new CarOrder(
                    resultSet.getInt("CAR_ORDER_ID"),
                    resultSet.getString("RENTERS_NAME"),
                    resultSet.getDate("DATE_LEASED").toLocalDate(),
                    resultSet.getBoolean("RENT_STATUS"),
                    resultSet.getDouble("CAR_REPAIR_BILL"),
                    resultSet.getString("INFO_ABOUT_DAMAGE"),
                    resultSet.getString("REJECTION_REASON"),
                    resultSet.getInt("CAR_ID")
            );
        }
    }
}
