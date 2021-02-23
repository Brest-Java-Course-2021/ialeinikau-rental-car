package com.epam.brest.model;

import java.util.Date;

public class CarOrder {

    private Integer orderId;

    private Integer carId;

    private String rentersName;

    private Date leaseDate;

    private Integer leaseTerm;

    private Date returnDate;

    private boolean rentStatus;

    private Double carRepairBill;

    private String informationAboutDamage;

    private String rejectionReason;

    public CarOrder() {
    }

    public CarOrder(Integer carId, String rentersName, Date leaseDate, Integer leaseTerm, Date returnDate, boolean rentStatus, Double carRepairBill, String informationAboutDamage, String rejectionReason) {
        this.carId = carId;
        this.rentersName = rentersName;
        this.leaseDate = leaseDate;
        this.leaseTerm = leaseTerm;
        this.returnDate = returnDate;
        this.rentStatus = rentStatus;
        this.carRepairBill = carRepairBill;
        this.informationAboutDamage = informationAboutDamage;
        this.rejectionReason = rejectionReason;
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

    public Date getLeaseDate() {
        return leaseDate;
    }

    public void setLeaseDate(Date leaseDate) {
        this.leaseDate = leaseDate;
    }

    public Integer getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(Integer leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
                ", leaseDate=" + leaseDate +
                ", leaseTerm=" + leaseTerm +
                ", returnDate=" + returnDate +
                ", rentStatus=" + rentStatus +
                ", carRepairBill=" + carRepairBill +
                ", informationAboutDamage='" + informationAboutDamage + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }
}
