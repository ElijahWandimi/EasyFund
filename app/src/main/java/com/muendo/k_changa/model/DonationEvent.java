package com.muendo.k_changa.model;

import java.util.ArrayList;

public class DonationEvent {
    private String title;
    private String description;
    private int payBillNumber;
    private Long targetAmount;
    private ArrayList<Custodian> custodians;

    public DonationEvent(String title, String description, int payBillNumber, Long targetAmount) {
        this.title = title;
        this.description = description;
        this.payBillNumber = payBillNumber;
        this.targetAmount = targetAmount;
    }

    public DonationEvent() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPayBillNumber() {
        return payBillNumber;
    }

    public void setPayBillNumber(int payBillNumber) {
        this.payBillNumber = payBillNumber;
    }

    public Long getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Long targetAmount) {
        this.targetAmount = targetAmount;
    }

    public ArrayList<Custodian> getCustodians() {
        return custodians;
    }

}
