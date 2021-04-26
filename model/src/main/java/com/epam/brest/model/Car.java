package com.epam.brest.model;

import java.util.Objects;

public class Car {

    private Integer carId;

    private String carModel;

    private Integer yearOfIssue;

    private String carColor;

    private Double pricePerDay;

    private boolean leased;

    public Car() {
    }

    public Car(Integer carId, String carModel, Integer yearOfIssue, String carColor, Double pricePerDay, boolean leased) {
        this.carId = carId;
        this.carModel = carModel;
        this.yearOfIssue = yearOfIssue;
        this.carColor = carColor;
        this.pricePerDay = pricePerDay;
        this.leased = leased;
    }

    public Car(String modelCar, Integer yearOfIssue, String carColor, Double pricePerDay, boolean leased) {
        this.carModel = modelCar;
        this.yearOfIssue = yearOfIssue;
        this.carColor = carColor;
        this.pricePerDay = pricePerDay;
        this.leased = leased;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getModelCar() {
        return carModel;
    }

    public void setModelCar(String modelCar) {
        this.carModel = modelCar;
    }

    public Integer getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Integer yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isLeased() {
        return leased;
    }

    public void setLeased(boolean leased) {
        this.leased = leased;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", modelCar='" + carModel + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", carColor='" + carColor + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", leased=" + leased +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return leased == car.leased && Objects.equals(carId, car.carId) && Objects.equals(carModel, car.carModel) && Objects.equals(yearOfIssue, car.yearOfIssue) && Objects.equals(carColor, car.carColor) && Objects.equals(pricePerDay, car.pricePerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carModel, yearOfIssue, carColor, pricePerDay, leased);
    }
}
