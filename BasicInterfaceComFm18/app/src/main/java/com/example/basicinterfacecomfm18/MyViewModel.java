package com.example.basicinterfacecomfm18;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MyViewModel extends androidx.lifecycle.ViewModel {

    public MutableLiveData<MyModel> mString = new MutableLiveData<>();


    public void setmString(MyModel s) {
        mString.setValue(s);
    }

    public LiveData<MyModel> getmString() {
        return mString;
    }
}

