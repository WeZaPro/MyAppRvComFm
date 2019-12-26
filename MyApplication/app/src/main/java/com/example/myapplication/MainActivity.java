package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements interfaceCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FragmentA fragmentA = new FragmentA();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_top,fragmentA)
                    .commit();
        }
    }

    @Override
    public void MyListener(MyChidModel myChidModel) {
        //Todo
        FragmentB fragmentB = new FragmentB();

        //get Value from FragmentA
        Bundle b = new Bundle();
        b.putParcelable("key",myChidModel);
        fragmentB.setArguments(b);

        //set Value to FragmentB
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer_top,fragmentB)
                .addToBackStack("")
                .commit();
    }
}
