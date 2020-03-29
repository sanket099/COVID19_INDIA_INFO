package com.example.covid_india;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_adapter extends RecyclerView.Adapter<recycler_adapter.MyViewHolder>  {



    private LayoutInflater inflater;
    private ArrayList<case_time_series> dataModelArrayList;
    private OnNoteList onNoteList;

    public recycler_adapter(Context ctx, ArrayList<case_time_series> dataModelArrayList,  OnNoteList onNoteList){

        inflater = LayoutInflater.from(ctx);
        this.dataModelArrayList = dataModelArrayList;
        this.onNoteList = onNoteList;
    }

    @NonNull
    @Override
    public recycler_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.row_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view,onNoteList);

        return holder;
    }

    @Override
    public void onBindViewHolder(recycler_adapter.MyViewHolder holder, int position) {

        //Picasso.get().load(dataModelArrayList.get(position).getImgURL()).into(holder.iv);
        holder.date_timeline.setText(dataModelArrayList.get(position).getDate());
        holder.daily_conf.setText("Daily Confirmed : "+ dataModelArrayList.get(position).getDaily_confirmed());
        holder.daily_rec.setText("Daily Recoveries : "+dataModelArrayList.get(position).getDaily_recovered());
        holder.daily_des.setText("Daily Deaths : "+dataModelArrayList.get(position).getDaily_deceased());
        holder.total_conf.setText("Total Confirmed : "+dataModelArrayList.get(position).getTotal_confirmed());
        holder.total_des.setText("Total Deaths : " +dataModelArrayList.get(position).getTotal_deceased() );
        holder.total_rec.setText("Total Recoveries : "+ dataModelArrayList.get(position).getTotal_recovered());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView date_timeline, daily_conf, daily_des, daily_rec, total_conf, total_des, total_rec;
        //ImageView iv;
        OnNoteList onNoteList;

        public MyViewHolder(View itemView, OnNoteList onNoteList) {
            super(itemView);

            date_timeline = (TextView) itemView.findViewById(R.id.date_timeline);
            daily_conf = (TextView) itemView.findViewById(R.id.daily_conf);
            daily_des = (TextView) itemView.findViewById(R.id.daily_des);
            daily_rec = itemView.findViewById(R.id.daily_rec);
            total_conf = itemView.findViewById(R.id.total_conf);
           total_des = itemView.findViewById(R.id.total_dec);
           total_rec = itemView.findViewById(R.id.total_rec);
            this.onNoteList = onNoteList;
            itemView.setOnClickListener(this);
            //iv = (ImageView) itemView.findViewById(R.id.iv);
        }

        @Override
        public void onClick(View v) {
            onNoteList.OnnoteClick(getAdapterPosition()); //text
        }
    }
    public interface OnNoteList {
        void OnnoteClick(int position);


    }
}