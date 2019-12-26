package com.example.rvfminterface2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvfminterface2.R;
import com.example.rvfminterface2.model.MyChidModel;
import com.example.rvfminterface2.myInterface.MyInterface;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyChidModel> mDataList;
    MyInterface listener;

    public MyAdapter(Context context, ArrayList<MyChidModel> mDataList, MyInterface listener) {
        this.context = context;
        this.mDataList = mDataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder._country.setText(mDataList.get(position).getCountry());
        holder._rates.setText("" + mDataList.get(position).getRates());
        holder._imageFlag.setImageResource(mDataList.get(position).getFlag());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView _country;
        TextView _rates;
        ImageView _imageFlag;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            _country = itemView.findViewById(R.id.tv_country);
            _rates = itemView.findViewById(R.id.tv_rate);
            _imageFlag = itemView.findViewById(R.id.imageFlag);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickItem = (int) v.getTag();
                    listener.myListener(mDataList.get(clickItem));
                    //Toast.makeText(context, "data is " +mDataList.get(clickItem).getRates(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        if (context instanceof MyInterface) {
            listener = (MyInterface) context;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        listener = null;
    }


}
