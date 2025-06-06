package com.example.currencytracker.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateResponse {
    private String result;
    private String base_code;
    private String target_code;
    private double conversion_rate;

    private double conversion_result;

    public String getResult() {
        return result;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }
}
