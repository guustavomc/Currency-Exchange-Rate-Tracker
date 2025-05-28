package com.example.currencytracker.dto;

public class ExchangeRateResponse {
    private String result;
    private String base;
    private String target;
    private double rate;
    private String error_message;

    public String getResult() {
        return result;
    }

    public String getBase() {
        return base;
    }

    public String getTarget() {
        return target;
    }

    public double getRate() {
        return rate;
    }

    public String getError_message() {
        return error_message;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
