package com.example.rvradiobuttonfm.model;

public class MyChidModel extends MyParentModel {

    private double valueInput;

    // output value
    private String country;
    boolean isChecked;

    public MyChidModel(double valueInput, String country) {
        this.valueInput = valueInput;
        this.country = country;

    }

    public MyChidModel(double rate, double valueInput, String country) {
        super(rate);
        this.valueInput = valueInput;
        this.country = country;

    }

    public double getValueInput() {
        return valueInput;
    }

    public void setValueInput(double valueInput) {
        this.valueInput = valueInput;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
