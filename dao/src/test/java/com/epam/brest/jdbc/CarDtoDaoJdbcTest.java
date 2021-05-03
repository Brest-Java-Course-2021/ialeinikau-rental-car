package com.epam.brest.jdbc;

import com.epam.brest.dao.CarDtoDao;
import com.epam.brest.model.dto.CarDto;
import com.epam.brest.testdb.SpringJdbcConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@Import({CarDtoDaoJdbc.class})
@PropertySource({"classpath:dao.properties"})
@ContextConfiguration(classes = SpringJdbcConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CarDtoDaoJdbcTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarDtoDaoJdbcTest.class);

    @Autowired
    private CarDtoDao carDtoDao;

    @Test
    void findAllQuantityOrders() {
        List<CarDto> cars = carDtoDao.findAllQuantityOrders();
        LOGGER.info(String.valueOf(cars.size()));
        LOGGER.info(cars.toString());
        assertNotNull(cars);
        assertTrue(cars.size() > 0);
        assertTrue(cars.get(0).getQuantityOrders().intValue() > 0);
    }
}