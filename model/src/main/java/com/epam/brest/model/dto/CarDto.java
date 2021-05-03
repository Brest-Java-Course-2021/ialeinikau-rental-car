package com.epam.brest.model.dto;

import java.math.BigDecimal;

public class CarDto {
    private Integer carId;

    private String carModel;

    private Integer yearOfIssue;

    private String carColor;

    private Double pricePerDay;

    private boolean leased;

    private Integer quantityOrders;

    public CarDto() {
    }

    public CarDto(String carModel, Integer yearOfIssue, String carColor, Double pricePerDay, boolean leased) {
        this.carModel = carModel;
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

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
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

    public Integer getQuantityOrders() {
        return quantityOrders;
    }

    public void setQuantityOrders(Integer quantityOrders) {
        this.quantityOrders = quantityOrders;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "carId=" + carId +
                ", carModel='" + carModel + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", carColor='" + carColor + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", leased=" + leased +
                ", quantityOrders=" + quantityOrders +
                '}';
    }
}
