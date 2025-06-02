package com.example.currencytracker.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateResponse {
    private String result;
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private String error_message;

    public String getResult() {
        return result;
    }

    public String getBase() {
        return base_code;
    }

    public String getTarget() {
        return target_code;
    }

    public double getRate() {
        return conversion_rate;
    }

    public String getError_message() {
        return error_message;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setBase(String base_code) {
        this.base_code = base_code;
    }

    public void setTarget(String target_code) {
        this.target_code = target_code;
    }

    public void setRate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
