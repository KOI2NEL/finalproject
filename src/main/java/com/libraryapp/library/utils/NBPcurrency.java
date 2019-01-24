package com.libraryapp.library.utils;

import java.util.List;

public class NBPcurrency {

    private String table;
    private String country;
    private String currency;

    private String code;
    private List<Rate >rates;

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
