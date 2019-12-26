package com.example.rvradiobuttonfm.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rvradiobuttonfm.R;
import com.example.rvradiobuttonfm.adapter.MyAdapter;
import com.example.rvradiobuttonfm.model.MyChidModel;
import com.example.rvradiobuttonfm.myInterface.MyInterface;

import java.util.ArrayList;

public class FragmentA extends Fragment implements MyInterface {

    private Context context;
    private ArrayList<MyChidModel> lstData = new ArrayList<>();
    RecyclerView recyclerView;
    private MyAdapter mAdapter;
    Button button;
    EditText editText;
    TextView textView;
    MyInterface listener;
    double number;

    FragmentB fragmentB = new FragmentB();


    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        initView(v);
        data();
        setAdapter(v);

        return v;
    }

    private void initView(View v) {
        button = v.findViewById(R.id.btn);
        editText = v.findViewById(R.id.editText);
        textView = v.findViewById(R.id.textView);
    }

    private void setAdapter(View v) {

        recyclerView = v.findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new MyAdapter(listener, lstData, getActivity());
        recyclerView.setAdapter(mAdapter);
    }

    private void data() {
        String country[] = {"Country 1 | ", "Country 2 | ", "Country 3 | ",
                "Country 4 | ", "Country 5 | ", "Country 6 | ", "Country 7 | ", "Country 8 | "};
        /*int image[] = {R.drawable.usa,R.drawable.japan,R.drawable.europe,R.drawable.usa,R.drawable.japan,
                R.drawable.europe,R.drawable.usa,R.drawable.japan,};*/

        double rates[] = {100, 200, 300, 400, 500, 600, 700, 800};

        int dataSize = country.length;

        for (int i = 0; i < dataSize; i++) {
            MyChidModel model = new MyChidModel(rates[i], country[i]);
            lstData.add(model);
        }
    }


    @Override
    public void itemCallback(int position) {
        MyChidModel p = lstData.get(position);
        p.setChecked(true);
        for (int x = 0; x < lstData.size(); x++) {
            MyChidModel ship = lstData.get(x);
            if (x != position) {
                ship.setChecked(false);
            }
        }
        mAdapter.notifyDataSetChanged();
        recyclerView.refreshDrawableState();
        /*Toast.makeText(getActivity(),"Click",Toast.LENGTH_SHORT).show();*/
    }
}
