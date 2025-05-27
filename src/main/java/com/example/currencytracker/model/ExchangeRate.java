package com.example.currencytracker.model;

import java.time.LocalDate;

public class ExchangeRate {
    private String base;
    private String target;

    private double rate;

    private LocalDate date;

    public ExchangeRate(String base, String target, double rate, LocalDate date){
        this.base=base;
        this.target=target;
        this.rate=rate;
        this.date=date;
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

    public LocalDate getDate() {
        return date;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
