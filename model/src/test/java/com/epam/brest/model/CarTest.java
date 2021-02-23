package com.epam.brest.model;

import org.junit.Assert;
import org.junit.Test;



public class CarTest {

    @Test
    public void getModelCarConstructor() {
        Car car = new Car("Audi",2010,"Black",20.1,true);
        Assert.assertEquals("Audi",car.getModelCar());
    }
}