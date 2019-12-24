package com.example.basicinterfacecomfm19.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyModel implements Parcelable {

    // input value
    private double rates;

    // output value
    private String country;

    boolean isChecked;

    public MyModel() {
    }

    public MyModel(double rates, String country) {
        this.rates = rates;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public double getRates() {
        return rates;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }




    protected MyModel(Parcel in) {
    }

    public static final Creator<MyModel> CREATOR = new Creator<MyModel>() {
        @Override
        public MyModel createFromParcel(Parcel in) {
            return new MyModel(in);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
