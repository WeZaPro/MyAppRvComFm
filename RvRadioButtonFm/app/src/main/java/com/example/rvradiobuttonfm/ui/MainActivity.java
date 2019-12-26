package com.example.rvradiobuttonfm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rvradiobuttonfm.R;
import com.example.rvradiobuttonfm.model.MyChidModel;
import com.example.rvradiobuttonfm.myInterface.MyInterface;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_main,fragmentA)
                    .commit();
        }




    }

}
