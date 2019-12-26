package com.example.basicinterfacecomfm17;

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

    View radioButtonView; // ใช้ Class View
    EditText editTextA,editTextB;
    Button button;
    private RadioGroup radioGroupNb;
    private int selectRBchoice;

    MyInterface listener;
    MyChidModel myChidModel;
    double numA,numB;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_a, container, false);

        initView(v);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    selectRB(v);

                    numA = Double.parseDouble(editTextA.getText().toString());
                    numB = Double.parseDouble(editTextB.getText().toString());

                    myChidModel = new MyChidModel(numA,numB,selectRBchoice);

                    listener.myListener(myChidModel);

                }catch (NumberFormatException e){
                    Toast.makeText(getActivity(),"Error input number "+e,Toast.LENGTH_LONG).show();
                }
            }
        });
        return v;
    }

    private void selectRB(View v) {
        int selectID = radioGroupNb.getCheckedRadioButtonId();
        radioButtonView = radioGroupNb.findViewById(selectID);

        switch (radioButtonView.getId()){
            case R.id.radioPlus:
                selectRBchoice = 0;
                break;
            case R.id.radioMinus:
                selectRBchoice = 1;
                break;
            case R.id.radioMultiply:
                selectRBchoice = 2;
                break;
            case R.id.radioDivide:
                selectRBchoice = 3;
                break;
        }
    }

    private void initView(View v) {
        editTextA = v.findViewById(R.id.editeTextA);
        editTextB = v.findViewById(R.id.editeTextB);
        button = v.findViewById(R.id.button);
        radioGroupNb = v.findViewById(R.id.radioGroupNb);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyInterface){
            listener = (MyInterface) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
