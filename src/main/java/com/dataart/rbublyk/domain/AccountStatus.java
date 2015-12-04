package com.dataart.rbublyk.domain;

public class AccountStatus {

    private int id;
    private boolean active;
    private String currency;
    private boolean exchangeSelfExcluded;
    private double exchangeLossLimit;
    private double exchangeExposureLimit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isExchangeSelfExcluded() {
        return exchangeSelfExcluded;
    }

    public void setExchangeSelfExcluded(boolean exchangeSelfExcluded) {
        this.exchangeSelfExcluded = exchangeSelfExcluded;
    }

    public double getExchangeLossLimit() {
        return exchangeLossLimit;
    }

    public void setExchangeLossLimit(double exchangeLossLimit) {
        this.exchangeLossLimit = exchangeLossLimit;
    }

    public double getExchangeExposureLimit() {
        return exchangeExposureLimit;
    }

    public void setExchangeExposureLimit(double exchangeExposureLimit) {
        this.exchangeExposureLimit = exchangeExposureLimit;
    }

}
