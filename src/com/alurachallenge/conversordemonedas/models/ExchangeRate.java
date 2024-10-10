package com.alurachallenge.conversordemonedas.models;

public class ExchangeRate {
    private  double conversion_rate;
    private  double conversion_result;

    public ExchangeRate(double conversion_rate, double conversion_result) {
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }


    public  ExchangeRate(ExchangeRateApi exchangeRateApi){
        this.conversion_rate = exchangeRateApi.conversion_rate();
        this.conversion_result = exchangeRateApi.conversion_result();
    }

    public double getConversion_rate() {
        return conversion_rate;
    }


    public double getConversion_result() {
        return conversion_result;
    }

    @Override
    public String toString() {
        return "( "+ getConversion_rate()+", " + getConversion_result() +")";
    }
}
