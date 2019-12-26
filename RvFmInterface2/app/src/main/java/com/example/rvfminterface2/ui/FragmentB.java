package com.example.rvfminterface2.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rvfminterface2.R;
import com.example.rvfminterface2.model.MyChidModel;

public class FragmentB extends Fragment {

    TextView tvCountry,tvRates,tvCalRates;
    ImageView imageView;
    EditText editText;
    Button button;

    MyChidModel myChidModel = new MyChidModel();

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        tvCountry = v.findViewById(R.id.tvCountry);
        tvRates = v.findViewById(R.id.tvRates);
        imageView = v.findViewById(R.id.imageView);
        editText = v.findViewById(R.id.edittext);
        button = v.findViewById(R.id.button);
        tvCalRates = v.findViewById(R.id.tvCalRates);

        // getData from FragmentA
        if(getArguments() != null){

            myChidModel = getArguments().getParcelable("key");

            tvCountry.setText(myChidModel.getCountry());
            tvRates.setText(""+myChidModel.getRates());
            imageView.setImageResource(myChidModel.getFlag());

            Toast.makeText(getActivity(),"get data : "+myChidModel.getCountry(),Toast.LENGTH_SHORT).show();
        }

        //calData(v);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myChidModel.setInputValues(Double.parseDouble(editText.getText().toString()));
                tvCalRates.setText(""+myChidModel.getResult());

            }
        });

        return v;
    }

    /*private void calData(View v) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double x = Double.parseDouble(editText.getText().toString());
                myChidModel = new MyChidModel(myChidModel.getRates(),x);

                tvCalRates.setText(""+myChidModel.getResult());

            }
        });
    }*/

}
