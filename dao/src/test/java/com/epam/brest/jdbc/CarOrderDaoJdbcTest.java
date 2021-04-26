package com.epam.brest.jdbc;

import com.epam.brest.dao.CarOrderDao;
import com.epam.brest.model.CarOrder;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJdbcTest
@Import({CarOrderDaoJdbc.class})
@PropertySource({"classpath:dao.properties"})
@ContextConfiguration(classes = SpringJdbcConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CarOrderDaoJdbcTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarOrderDaoJdbcTest.class);

    @Autowired
    private CarOrderDao carOrderDao;

    @Test
    void findAll() {
        List<CarOrder> carOrders= carOrderDao.findAll();
        Assert.assertNotNull(carOrders);
        Assert.assertTrue(carOrders.size()>0);
        LOGGER.info(carOrders.toString());
    }

    @Test
    void findById() {
        List<CarOrder> carOrders= carOrderDao.findAll();
        Assert.assertNotNull(carOrders);
        Assert.assertTrue(carOrders.size()>0);

        Integer carOrderId = carOrders.get(0).getOrderId();
        CarOrder expCarOrder = carOrderDao.findById(carOrderId).get();
        Assert.assertEquals(carOrderId , expCarOrder.getOrderId());
        Assert.assertEquals(carOrders.get(0).getRentersName() , expCarOrder.getRentersName());
        LOGGER.info(carOrders.get(0).toString());
        LOGGER.info(expCarOrder.toString());
        Assert.assertEquals(carOrders.get(0).toString() , expCarOrder.toString());
    }

    @Test
    void create() {
        List<CarOrder> carOrders= carOrderDao.findAll();
        Assert.assertNotNull(carOrders);
        Assert.assertTrue(carOrders.size()>0);

        carOrderDao.create(new CarOrder("Sai", LocalDate.of(2020,04,30),false,0.0,null,null,4));
        List<CarOrder> realCar = carOrderDao.findAll();
        Assertions.assertEquals(carOrders.size() + 1, realCar.size());
        LOGGER.info(realCar.get(realCar.size()-1).toString());
    }

    @Test
    void update() {
        List<CarOrder> carOrders= carOrderDao.findAll();
        Assert.assertNotNull(carOrders);
        Assert.assertTrue(carOrders.size()>0);

        CarOrder carOrder = carOrders.get(0);
        carOrder.setRentersName("Snitko");
        carOrder.setDateLeased(LocalDate.of(2019,9,30));
        carOrder.setRentStatus(true);
        carOrder.setCarRepairBill(450.4);
        carOrder.setInformationAboutDamage("Broke a engine");
        carOrder.setRejectionReason("i do know");
        carOrder.setCarId(2);
        carOrderDao.update(carOrder);

        Optional<CarOrder> realCarOrder = carOrderDao.findById(carOrder.getOrderId());
        Assertions.assertEquals("Snitko", realCarOrder.get().getRentersName());
        Assertions.assertEquals(LocalDate.of(2019,9,30), realCarOrder.get().getDateLeased());
        Assertions.assertEquals(true, realCarOrder.get().isRentStatus());
        Assertions.assertEquals(450.4, realCarOrder.get().getCarRepairBill());
        Assertions.assertEquals("Broke a engine", realCarOrder.get().getInformationAboutDamage());
        Assertions.assertEquals("i do know", realCarOrder.get().getRejectionReason());
        Assertions.assertEquals(2, realCarOrder.get().getCarId());
    }

    @Test
    void delete() {
        List<CarOrder> carOrders= carOrderDao.findAll();
        Assert.assertNotNull(carOrders);
        Assert.assertTrue(carOrders.size()>0);
        LOGGER.info(carOrders.toString());

        carOrderDao.delete(4);
        List<CarOrder> realCarOrders = carOrderDao.findAll();
        LOGGER.info(realCarOrders.toString());
        Assert.assertNotNull(carOrders);
        Assert.assertEquals(carOrders.size()-1,realCarOrders.size());
    }
}