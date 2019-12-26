package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParentModel implements Parcelable {

    double rates;
    String country;
    int image;

    public MyParentModel() {
    }

    public MyParentModel(double rates) {
        this.rates = rates;
    }

    public MyParentModel(double rates, String country, int image) {
        this.rates = rates;
        this.country = country;
        this.image = image;
    }

    protected MyParentModel(Parcel in) {
        rates = in.readDouble();
        country = in.readString();
        image = in.readInt();
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

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(rates);
        dest.writeString(country);
        dest.writeInt(image);
    }
}
