package com.example.myapplication;

public class MyChidModel extends MyParentModel{

    double result, inputValue;

    public MyChidModel(double result) {
        this.result = result;
    }

    public MyChidModel() {
    }

    public MyChidModel(double rates, String country, int image) {
        super(rates, country, image);
    }

    public MyChidModel(double rates,double inputValue) {
        super(rates);

        setResule(rates,inputValue);
    }

    private void setResule(double rates, double inputValue) {
        this.result = rates*inputValue;
    }

    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }

    public double getResult() {
        return result;
    }
}
