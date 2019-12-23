package com.taweesak.basicinterfacecomfm16;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FragmentA extends Fragment {

    EditText editTextA,editTextB;
    Button button;
    private RadioGroup radioGroupNb;
    View radioButtonView; // ใช้ Class View

    MyInterface listener;
    private int chkRadio;
    MyChidModel myChidModel;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        findView(v);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    // check radio button id
                    checkRadioBtn(view);

                    // input data
                    double numA = Double.parseDouble(editTextA.getText().toString());
                    double numB = Double.parseDouble(editTextB.getText().toString());
                    myChidModel = new MyChidModel(numA,numB,chkRadio);

                    listener.MyListener(myChidModel);

                }catch (NumberFormatException e){
                    Toast.makeText(getActivity(),"Error number "+e,Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private void checkRadioBtn(View view) {
        int selectRadioBtn = radioGroupNb.getCheckedRadioButtonId();
        radioButtonView = radioGroupNb.findViewById(selectRadioBtn);

        switch (radioButtonView.getId()){
            case R.id.radioPlus:
                chkRadio = 0;
                break;

            case R.id.radioMinus:
                chkRadio = 1;
                break;

            case R.id.radioMultiply:
                chkRadio = 2;
                break;

            case R.id.radioDivide:
                chkRadio = 3;
                break;
        }
    }

    private void findView(View v) {
        button = v.findViewById(R.id.button);
        editTextA = v.findViewById(R.id.editeTextA);
        editTextB = v.findViewById(R.id.editeTextB);
        radioGroupNb = v.findViewById(R.id.radioGroupNb);
    }

    // embed listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MyInterface){
            listener = (MyInterface) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
