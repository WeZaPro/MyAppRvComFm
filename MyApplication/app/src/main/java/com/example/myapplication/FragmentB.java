package com.example.myapplication;

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

public class FragmentB extends Fragment {

    TextView tvCountry,tvRates,tvCalRates;
    ImageView imageView;
    Button button;
    EditText edittext;
    MyChidModel myChidModel = new MyChidModel();
    MyChidModel myChidModel1 = new MyChidModel();

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_b, container, false);

            if(getArguments() != null){

                findView(v);

                myChidModel = getArguments().getParcelable("key");

                tvCountry.setText(myChidModel.getCountry());
                tvRates.setText(""+myChidModel.getRates());
                imageView.setImageResource(myChidModel.getImage());

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        myChidModel1 = new MyChidModel(myChidModel.getRates(),Double.parseDouble(edittext.getText().toString()));

                        Toast.makeText(getActivity(),"data get is "+myChidModel1.getResult(),Toast.LENGTH_SHORT).show();
                    }
                });
            }

        return v;
    }

    private void findView(View v) {
        tvCountry = v.findViewById(R.id.tvCountry);
        tvRates = v.findViewById(R.id.tvRates);
        tvCalRates = v.findViewById(R.id.tvCalRates);
        imageView = v.findViewById(R.id.imageView);
        button = v.findViewById(R.id.button);
        edittext = v.findViewById(R.id.edittext);

    }

}
