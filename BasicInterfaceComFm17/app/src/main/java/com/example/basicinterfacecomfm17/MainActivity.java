package com.example.basicinterfacecomfm17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_top,fragmentA)
                    .addToBackStack("")
                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_bottom,fragmentB)
                    .addToBackStack("")
                    .commit();
        }

    }

    @Override
    public void myListener(MyChidModel myChidModel) {
        FragmentB fragmentB = new FragmentB();

        Bundle b = new Bundle();
        b.putParcelable("key",myChidModel);
        fragmentB.setArguments(b);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_bottom,fragmentB)
                .addToBackStack("")
                .commit();
    }
}
