package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH>{

    Context context;
    ArrayList<MyChidModel> mDataList;
    interfaceCallback callback;

    public MyAdapter(Context context, ArrayList<MyChidModel> mDataList, interfaceCallback callback) {
        this.context = context;
        this.mDataList = mDataList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder._country.setText(""+mDataList.get(position).getCountry());
        holder._rates.setText(""+mDataList.get(position).getRates());
        holder._imageFlag.setImageResource(Integer.parseInt(""+mDataList.get(position).getImage()));
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class VH extends RecyclerView.ViewHolder{

        TextView _country;
        TextView _rates;
        ImageView _imageFlag;

        public VH(@NonNull View itemView) {
            super(itemView);
            _country = itemView.findViewById(R.id.tv_country);
            _rates = itemView.findViewById(R.id.tv_rate);
            _imageFlag = itemView.findViewById(R.id.imageFlag);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickItem = (int) v.getTag();

                    callback.MyListener(mDataList.get(clickItem));

                    Toast.makeText(context,"item is : "+mDataList.get(clickItem).getCountry(),
                            Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        if (context instanceof interfaceCallback){ // ต้องเป็น Context เท่านั้น
            callback = (interfaceCallback) context;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);

        callback = null;
    }
}
