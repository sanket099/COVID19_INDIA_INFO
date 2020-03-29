package com.example.covid_india;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_adapter_states extends RecyclerView.Adapter<recycler_adapter_states.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<statewise> arrayList;
    private OnNoteList onNoteList;


    public recycler_adapter_states(Context ctx, ArrayList<statewise> arrayList, OnNoteList onNoteList) {
        inflater = LayoutInflater.from(ctx);
        this.arrayList = arrayList;
        this.onNoteList = onNoteList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_layout_states, parent, false);
        MyViewHolder holder = new MyViewHolder(view,  onNoteList);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.state_name.setText(arrayList.get(position).getState());
        holder.state_recovered.setText("Recovered Cases: "+ arrayList.get(position).getRecovered());
        holder.state_deaths.setText("Unfortunate Deaths : "+arrayList.get(position).getDeaths());
        holder.state_confirmed.setText("Confirmed cases : "+arrayList.get(position).getConfirmed());
        holder.state_active.setText("Active Cases : "+arrayList.get(position).getActive());
        holder.update_date.setText("Last Updated : " +arrayList.get(position).getDate() );
        //holder.total_rec.setText("Total Recoveries : "+ dataModelArrayList.get(position).getTotal_recovered());

    }




    @Override
    public int getItemCount() {
        return arrayList.size();
    }


     static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView state_name, state_confirmed, state_deaths, update_date, state_recovered, state_active;
        //ImageView iv;
        OnNoteList onNoteList;

        public MyViewHolder(@NonNull View itemView, OnNoteList onNoteList) {
            super(itemView);

            state_name = itemView.findViewById(R.id.state_name);
            state_active = itemView.findViewById(R.id.state_active);
            state_confirmed = itemView.findViewById(R.id.state_confirmed);
            state_deaths = itemView.findViewById(R.id.state_deaths);
            update_date = itemView.findViewById(R.id.date_update);
            state_recovered = itemView.findViewById(R.id.state_recovered);
            this.onNoteList = (OnNoteList) onNoteList;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            onNoteList.OnnoteClick(getAdapterPosition());

        }


        }
    public interface OnNoteList{
        void OnnoteClick(int position);
    }
}
