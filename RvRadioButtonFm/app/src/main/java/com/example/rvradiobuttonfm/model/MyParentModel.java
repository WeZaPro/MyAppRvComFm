package com.example.rvradiobuttonfm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParentModel implements Parcelable {

    private double rate;

    public MyParentModel() {
    }

    public MyParentModel(double rate) {
        this.rate = rate;
    }

    protected MyParentModel(Parcel in) {
        rate = in.readDouble();
    }

    public static final Creator<MyParentModel> CREATOR = new Creator<MyParentModel>() {
        @Override
        public MyParentModel createFromParcel(Parcel in) {
            return new MyParentModel(in);
        }

        @Override
        public MyParentModel[] newArray(int size) {
            return new MyParentModel[size];
        }
    };

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(rate);
    }
}
