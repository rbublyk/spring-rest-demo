package com.dataart.rbublyk.dto;

import com.dataart.rbublyk.domain.AccountStatus;

import java.util.UUID;

public class AccountStatusDTO {

    private String accountId;
    private boolean active;
    private String currency;
    private boolean exchangeSelfExcluded;
    private double exchangeLossLimit;
    private double exchangeExposureLimit;

    public AccountStatusDTO(AccountStatus status, UUID accountId) {
        this.accountId = accountId.toString();
        this.active = status.isActive();
        this.currency = status.getCurrency();
        this.exchangeSelfExcluded = status.isExchangeSelfExcluded();
        this.exchangeLossLimit = status.getExchangeLossLimit();
        this.exchangeExposureLimit = status.getExchangeExposureLimit();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStatusDTO that = (AccountStatusDTO) o;

        if (active != that.active) return false;
        if (exchangeSelfExcluded != that.exchangeSelfExcluded) return false;
        if (Double.compare(that.exchangeLossLimit, exchangeLossLimit) != 0) return false;
        if (Double.compare(that.exchangeExposureLimit, exchangeExposureLimit) != 0) return false;
        if (!accountId.equals(that.accountId)) return false;
        return !(currency != null ? !currency.equals(that.currency) : that.currency != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountId.hashCode();
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (exchangeSelfExcluded ? 1 : 0);
        temp = Double.doubleToLongBits(exchangeLossLimit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(exchangeExposureLimit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
