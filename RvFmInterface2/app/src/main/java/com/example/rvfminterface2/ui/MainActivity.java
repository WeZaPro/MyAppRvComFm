package com.example.rvfminterface2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rvfminterface2.R;
import com.example.rvfminterface2.model.MyChidModel;
import com.example.rvfminterface2.myInterface.MyInterface;

public class MainActivity extends AppCompatActivity implements MyInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_top,fragmentA)
                    .commit();

        }
    }

    @Override
    public void myListener(MyChidModel myChidModel) {
        //Todo

        FragmentB fragmentB = new FragmentB();

        // getData From RecyclerView Listener
        Bundle b = new Bundle();
        b.putParcelable("key",myChidModel);
        fragmentB.setArguments(b);

        // sendData to FragmentB
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer_top,fragmentB)
                .addToBackStack("")
                .commit();
    }
}
