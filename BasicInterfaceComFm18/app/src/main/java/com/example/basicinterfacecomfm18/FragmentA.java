package com.example.basicinterfacecomfm18;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentA extends Fragment implements MyAdapter.itemCallback{

    private Context context;
    private ArrayList<MyModel> lstData = new ArrayList<>();
    RecyclerView recyclerView;
    private MyAdapter mAdapter;
    MyViewModel viewModel;
    Button button;
    EditText editText;
    TextView textView;
    double number;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        initView(v);
        data();
        setAdapter(v);
        getDataFromViewModel();

        return v;
    }


    private void setAdapter(View v) {
        recyclerView = v.findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new MyAdapter(getActivity(),lstData,this);
        recyclerView.setAdapter(mAdapter);
    }

    private void initView(View v) {
        button = v.findViewById(R.id.btn);
        editText = v.findViewById(R.id.editText);
        textView = v.findViewById(R.id.textView);
    }

    private void getDataFromViewModel() {

        viewModel.getmString().observe(getActivity(), new Observer<MyModel>() {
            @Override
            public void onChanged(MyModel model) {
                Toast.makeText(getActivity(), "onFmA country is : " + model.getCountry()+" onFmA rates is : " +model.getRates(), Toast.LENGTH_SHORT).show();
                textView.setText(""+model.getRates());

                //Toast.makeText(getActivity(), "on main FM Text is : " + model.getImage(), Toast.LENGTH_SHORT).show();
                /*textView.setText("" + model.getText());
                flagImage.setImageResource(model.getImage());*/

            }
        });
    }

    private void data() {
        String country[] = {"Country 1 | ","Country 2 | ","Country 3 | ",
                "Country 4 | ","Country 5 | ","Country 6 | ","Country 7 | ","Country 8 | "};
        /*int image[] = {R.drawable.usa,R.drawable.japan,R.drawable.europe,R.drawable.usa,R.drawable.japan,
                R.drawable.europe,R.drawable.usa,R.drawable.japan,};*/

        double rates[] = {100,200,300,400,500,600,700,800};

        int dataSize = country.length;

        for (int i = 0; i <dataSize ; i++) {
            MyModel model = new MyModel(rates[i],country[i]); //(String country , double numberInput, double rates)
            lstData.add(model);
        }

    }

    @Override
    public void itemCallback(int position) {
        MyModel p = lstData.get(position);
        p.setChecked(true);
        for (int x = 0; x < lstData.size(); x++) {
            MyModel ship = lstData.get(x);
            if (x != position) {
                ship.setChecked(false);
            }
        }

        mAdapter.notifyDataSetChanged();
        recyclerView.refreshDrawableState();
    }
}
