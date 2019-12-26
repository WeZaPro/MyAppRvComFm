package com.example.rvfminterface2.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rvfminterface2.R;
import com.example.rvfminterface2.adapter.MyAdapter;
import com.example.rvfminterface2.model.MyChidModel;
import com.example.rvfminterface2.myInterface.MyInterface;

import java.util.ArrayList;

public class FragmentA extends Fragment {

    private ArrayList<MyChidModel> lstData = new ArrayList<>();
    RecyclerView recyclerView;
    //Button button;
    MyAdapter myAdapter;
    Context context;
    MyInterface listener;
    View v;


    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(v == null){ // แก้ไขเรื่อง Dupplicate item in Recyclerview

            v = inflater.inflate(R.layout.fragment_a, container, false);
            //button = v.findViewById(R.id.button);
            recyclerView = v.findViewById(R.id.myRecyclerView);

            data();

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            myAdapter = new MyAdapter(getActivity(),lstData,listener);
            recyclerView.setAdapter(myAdapter);
        }

        return v;
    }


    private void data() {
        String country_[] = {"brazil","ghana","island","japan","polynesia","southkorea",
                "spain","uk","usa"};
        double rates_[] = {10.51,20.52,30.53,40.54,50.55,60.56,70.57,80.58,90.59};
        int image_[] = {R.drawable.brazil,R.drawable.ghana,R.drawable.island
                ,R.drawable.japan,R.drawable.polynesia,R.drawable.southkorea
                ,R.drawable.spain,R.drawable.unitedkingdom,R.drawable.usa};


        int dataSize = country_.length;

        for (int i = 0; i <dataSize ; i++) {
            MyChidModel model = new MyChidModel(rates_[i],country_[i],image_[i]);
            lstData.add(model);
        }
    }

}
