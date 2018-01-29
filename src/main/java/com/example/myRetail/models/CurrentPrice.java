package com.example.myRetail.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties( value = {"createdAt"}, allowGetters = true)
public class CurrentPrice {

    private Long value;

    private String currencyCode;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "CurrentPrice{" +
                "value=" + value +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
