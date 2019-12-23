package com.taweesak.basicinterfacecomfm16;

import android.os.Parcel;

public class MyChidModel extends MyParentModel{

    private double result;
    //private int btnClick;

    //MyParentModel myParentModel = new MyParentModel();

    public MyChidModel() {
    }

    /*public MyChidModel(double result, int btnClick) {
        this.result = result;
        this.btnClick = btnClick;
    }*/

    public MyChidModel(double numA, double numB, int btnClick) {
        super(numA, numB);
        //this.btnClick = btnClick;
        setResult(numA,numB,btnClick);
    }

    public void setResult(double numA, double numB, int btnClick) {

        switch (btnClick){
            case 0:
                this.result = numA+numB;
                break;
            case 1:
                this.result = numA-numB;
                break;
            case 2:
                this.result = numA*numB;
                break;
            case 3:
                this.result = numA/numB;
                break;
        }
    }

    public double getResult() {
        return result;
    }

}
