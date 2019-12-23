package com.taweesak.basicinterfacecomfm16;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParentModel implements Parcelable {

    private double numA,numB;

    public MyParentModel() {
    }

    public MyParentModel(double numA, double numB) {
        this.numA = numA;
        this.numB = numB;
    }

    protected MyParentModel(Parcel in) {
        numA = in.readDouble();
        numB = in.readDouble();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(numA);
        parcel.writeDouble(numB);
    }

}
