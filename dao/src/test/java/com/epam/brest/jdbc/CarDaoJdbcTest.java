package com.epam.brest.jdbc;

import com.epam.brest.dao.CarDao;
import com.epam.brest.model.Car;
import com.epam.brest.testdb.SpringJdbcConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJdbcTest
@Import({CarDaoJdbc.class})
@PropertySource({"classpath:dao.properties"})
@ContextConfiguration(classes = SpringJdbcConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CarDaoJdbcTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarDaoJdbcTest.class);

    @Autowired
    private CarDao carDao;

    @Test
    public void findAllTest() {
        List<Car> cars= carDao.findAll();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size()>0);
        LOGGER.info(cars.toString());
    }

   @Test
    public void findByIdTest() {
        List<Car> cars= carDao.findAll();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size()>0);

        Integer carId = cars.get(0).getCarId();
        Car expCar = carDao.findById(carId).get();
        Assert.assertEquals(carId , expCar.getCarId());
        Assert.assertEquals(cars.get(0).getModelCar() , expCar.getModelCar());
        Assert.assertEquals(cars.get(0) , expCar);
    }

    @Test
    public void createCarTest() {
        List<Car> cars= carDao.findAll();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size()>0);

        carDao.create(new Car("Audi",2010,"Black",20.0,false));
        List<Car> realCar = carDao.findAll();
        Assertions.assertEquals(cars.size() + 1, realCar.size());
    }

    @Test
    public void updateCarTest() {
        List<Car> cars= carDao.findAll();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size()>0);

        Car car = cars.get(0);
        System.out.println(car.getModelCar());
        car.setModelCar("Ford");
        car.setYearOfIssue(2020);
        car.setCarColor("Pink");
        car.setPricePerDay(54.4);
        car.setLeased(true);
        carDao.update(car);

        Optional<Car> realCar = carDao.findById(car.getCarId());
        Assertions.assertEquals("Ford", realCar.get().getModelCar());
        Assertions.assertEquals(2020, realCar.get().getYearOfIssue());
        Assertions.assertEquals("Pink", realCar.get().getCarColor());
        Assertions.assertEquals(54.4, realCar.get().getPricePerDay());
        Assertions.assertEquals(true, realCar.get().isLeased());
    }

    //TODO fix this test
    @Test
    public void deleteCarTest() {
        List<Car> cars= carDao.findAll();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size()>0);

        //if car don't have dependencies
        carDao.create(new Car("Audi",2010,"Black",20.0,false));
        carDao.delete(5);
        List<Car> realCar = carDao.findAll();
        Assertions.assertEquals(cars.size() , realCar.size());

        //if car have dependencies
        carDao.delete(1);
        carDao.create(new Car("Audi",2010,"Black",20.0,false));
        List<Car> carAfterAddCar= carDao.findAll();
        Assertions.assertNotEquals(cars.size(),carAfterAddCar.size());


    }


}