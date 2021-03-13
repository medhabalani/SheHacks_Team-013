package com.example.peacify;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<Model> mList;
    Context context;
    public MyAdapter(Context context,ArrayList<Model> mList){
        this.mList=mList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.descri.setText(model.getDesc());
        //holder.desc.setText(model.getDesc());
        holder.time.setText(model.getTime());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView time,descri;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.date_text);
            descri=itemView.findViewById(R.id.daily_desc);
        }
    }

}

