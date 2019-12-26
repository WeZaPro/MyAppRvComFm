package com.example.rvfminterface2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyChidModel implements Parcelable {

    double result;
    String country;
    int flag;
    double rates,inputValues;

    public MyChidModel() {
    }

    public MyChidModel(double rates, double inputValues, String country, int flag) {

        this.rates = rates;
        this.inputValues = inputValues;
        this.country = country;
        this.flag = flag;

    }

    public MyChidModel(double rates, String country, int flag) {

        this.rates = rates;
        this.country = country;
        this.flag = flag;

    }

    public MyChidModel(double rates, double inputValues) {
        setResult(rates,inputValues);
    }

    protected MyChidModel(Parcel in) {
        result = in.readDouble();
        country = in.readString();
        flag = in.readInt();
        rates = in.readDouble();
        inputValues = in.readDouble();
    }

    public static final Creator<MyChidModel> CREATOR = new Creator<MyChidModel>() {
        @Override
        public MyChidModel createFromParcel(Parcel in) {
            return new MyChidModel(in);
        }

        @Override
        public MyChidModel[] newArray(int size) {
            return new MyChidModel[size];
        }
    };

    public double getResult() {
        return result;
    }

    public void setResult(double rates, double inputValues) {
        this.result = rates*inputValues;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(int rates) {
        this.rates = rates;
    }

    public void setInputValues(double inputValues) {
        this.inputValues = inputValues;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(result);
        dest.writeString(country);
        dest.writeInt(flag);
        dest.writeDouble(rates);
        dest.writeDouble(inputValues);
    }
}
