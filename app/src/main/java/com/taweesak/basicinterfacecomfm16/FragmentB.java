package com.taweesak.basicinterfacecomfm16;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        TextView textView = v.findViewById(R.id.textView);
        MyChidModel myChidModel = new MyChidModel();

        if(getArguments() != null){
            myChidModel = getArguments().getParcelable("key");
            textView.setText(""+myChidModel.getResult());
        }
        return v;
    }
}
