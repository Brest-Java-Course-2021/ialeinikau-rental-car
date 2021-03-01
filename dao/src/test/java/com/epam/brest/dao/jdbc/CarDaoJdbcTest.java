package com.epam.brest.dao.jdbc;

import com.epam.brest.dao.CarDao;
import com.epam.brest.model.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml","classpath*:test-dao.xml"})
public class CarDaoJdbcTest {

    @Autowired
    private CarDao carDao;

    @Test
    public void findAll() {
        List<Car> cars= carDao.findAll();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size()>0);
    }
}