package com.example.covid_india;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_adapter_district extends RecyclerView.Adapter<recycler_adapter_district.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<String> string_arraylist;
    private ArrayList<model_dist> data_arraylist;

    public recycler_adapter_district(Context ctx, ArrayList<String> string_arraylist, ArrayList<model_dist> data_arraylist) {
        inflater = LayoutInflater.from(ctx);
        this.string_arraylist = string_arraylist;
        this.data_arraylist = data_arraylist;
    }

    //private ArrayList<>

    @NonNull
    @Override
    public recycler_adapter_district.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_layout_district, parent, false);
        recycler_adapter_district.MyViewHolder holder = new recycler_adapter_district.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull recycler_adapter_district.MyViewHolder holder, int position) {
        holder.district_name.setText(string_arraylist.get(position).toString());
        holder.district_confirmed.setText("Confirmed Cases : "+data_arraylist.get(position).getConfirmed());

        holder.last_updated.setText(data_arraylist.get(position).getLastupdatedtime());

    }

    @Override
    public int getItemCount() {
        return string_arraylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView district_name, district_confirmed, last_updated;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            district_confirmed = itemView.findViewById(R.id.confirmed_district);
            district_name = itemView.findViewById(R.id.name_district);
            last_updated = itemView.findViewById(R.id.last_updated);


        }
    }
}
