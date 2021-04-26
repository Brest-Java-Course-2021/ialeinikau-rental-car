package com.epam.brest.model;

import java.time.LocalDate;

public class CarOrder {

    private Integer orderId;

    private String rentersName;

    private LocalDate dateLeased;

    private boolean rentStatus;

    private Double carRepairBill;

    private String informationAboutDamage;

    private String rejectionReason;

    private Integer carId;

    public CarOrder(String rentersName, LocalDate dateLeased, boolean rentStatus, Double carRepairBill, String informationAboutDamage, String rejectionReason, Integer carId) {
        this.rentersName = rentersName;
        this.dateLeased = dateLeased;
        this.rentStatus = rentStatus;
        this.carRepairBill = carRepairBill;
        this.informationAboutDamage = informationAboutDamage;
        this.rejectionReason = rejectionReason;
        this.carId = carId;
    }

    public CarOrder(Integer orderId, String rentersName, LocalDate dateLeased, boolean rentStatus, Double carRepairBill, String informationAboutDamage, String rejectionReason, Integer carId) {
        this.orderId = orderId;
        this.rentersName = rentersName;
        this.dateLeased = dateLeased;
        this.rentStatus = rentStatus;
        this.carRepairBill = carRepairBill;
        this.informationAboutDamage = informationAboutDamage;
        this.rejectionReason = rejectionReason;
        this.carId = carId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getRentersName() {
        return rentersName;
    }

    public void setRentersName(String rentersName) {
        this.rentersName = rentersName;
    }

    public LocalDate getDateLeased() {
        return dateLeased;
    }

    public void setDateLeased(LocalDate dateLeased) {
        this.dateLeased = dateLeased;
    }

    public boolean isRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(boolean rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Double getCarRepairBill() {
        return carRepairBill;
    }

    public void setCarRepairBill(Double carRepairBill) {
        this.carRepairBill = carRepairBill;
    }

    public String getInformationAboutDamage() {
        return informationAboutDamage;
    }

    public void setInformationAboutDamage(String informationAboutDamage) {
        this.informationAboutDamage = informationAboutDamage;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    @Override
    public String toString() {
        return "CarOrder{" +
                "orderId=" + orderId +
                ", carId=" + carId +
                ", rentersName='" + rentersName + '\'' +
                ", dateLeased=" + dateLeased +
                ", rentStatus=" + rentStatus +
                ", carRepairBill=" + carRepairBill +
                ", informationAboutDamage='" + informationAboutDamage + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }
}
