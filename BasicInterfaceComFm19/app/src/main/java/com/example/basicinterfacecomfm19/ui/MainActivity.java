package com.example.basicinterfacecomfm19.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.basicinterfacecomfm19.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentContainer_main,fragmentA)
                .addToBackStack("")
                .commit();

    }
}
