package com.example.basicinterfacecomfm18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
