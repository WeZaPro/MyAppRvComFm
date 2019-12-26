package com.example.rvradiobuttonfm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvradiobuttonfm.R;
import com.example.rvradiobuttonfm.model.MyChidModel;
import com.example.rvradiobuttonfm.myInterface.MyInterface;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH>{

    MyInterface listener;
    ArrayList<MyChidModel> mDataList;
    Context context;

    public MyAdapter(MyInterface listener, ArrayList<MyChidModel> mDataList, Context context) {
        this.listener = listener;
        this.mDataList = mDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        MyChidModel myModel = mDataList.get(position);
        holder._country.setText(mDataList.get(position).getCountry());
        holder._rates.setText("" + mDataList.get(position).getRate());
        //holder._imageFlag.setImageResource(mDataList.get(position).getImage());
        holder.itemView.setTag(position);
        holder.radioButton.setChecked(myModel.isChecked());

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class VH extends RecyclerView.ViewHolder{

        RadioButton radioButton;
        TextView _country, _rates;
        /*ImageView _imageFlag;*/

        public VH(@NonNull View itemView) {
            super(itemView);


            radioButton = itemView.findViewById(R.id.radio_button);
            _country = itemView.findViewById(R.id.tv_country);
            _rates = itemView.findViewById(R.id.tv_rates);
            //_imageFlag = itemView.findViewById(R.id.imageFlag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int clickItem = (int) v.getTag();

                    updateCart(mDataList.get(clickItem));

                    listener.itemCallback(clickItem);
                    notifyDataSetChanged();
                }
            });

        }
    }


    private void updateCart(MyChidModel cartModel) {
        String txt = String.valueOf(cartModel.getCountry());
        //int imageFlags = cartModel.getImage();
        Log.d(TAG, "updateText: " + txt);
        //Log.d(TAG, "updateImage: " + imageFlags);

        // setData to viewModel
        //viewModel.setmString(cartModel);
        Toast.makeText(context,"Click",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (recyclerView instanceof MyInterface){
            listener = (MyInterface) recyclerView;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        listener = null;
    }
}
