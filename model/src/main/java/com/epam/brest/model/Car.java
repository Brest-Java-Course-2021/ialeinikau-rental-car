package com.epam.brest.model;

public class Car {

    private Integer carId;

    private String modelCar;

    private Integer yearOfIssue;

    private String carColor;

    private Double pricePerDay;

    private boolean leased;

    public Car() {
    }

    public Car(String modelCar, Integer yearOfIssue, String carColor, Double pricePerDay, boolean leased) {
        this.modelCar = modelCar;
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
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
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
                ", modelCar='" + modelCar + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", carColor='" + carColor + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", leased=" + leased +
                '}';
    }
}
