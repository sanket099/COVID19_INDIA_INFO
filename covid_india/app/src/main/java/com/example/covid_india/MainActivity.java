package com.example.covid_india;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv_tips, active , confirmed, deaths, date , recovered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_tips = findViewById(R.id.tv_tips);
        active =findViewById(R.id.active);
        confirmed = findViewById(R.id.confirmed);
        deaths  = findViewById(R.id.deaths);
        date = findViewById(R.id.date);
        recovered = findViewById(R.id.recovered);
        tips();
        get_total();

    }

    public void get_total(){

        //api callback
        //for total number of cases

        Call<cases> call = retrofit_client.getInstance().getapi().latest();
        call.enqueue(new Callback<cases>() {
            @Override
            public void onResponse(Call<cases> call, Response<cases> response) {

                if(!(response.code() ==200)){
                    System.out.println("error ");
                    return;
                }

                cases cases = response.body();
                assert cases != null;
                ArrayList<statewise> arrayList = cases.getStatewiseArrayList();
                active.setText("Active Cases : "+arrayList.get(0).getActive());
                confirmed.setText("Confirmed Cases : "+arrayList.get(0).getConfirmed());
                deaths.setText("Unfortunate Deaths : "+arrayList.get(0).getDeaths());
                recovered.setText("Recoveries : "+arrayList.get(0).getRecovered());



            }

            @Override
            public void onFailure(Call<cases> call, Throwable t) {
                System.out.println("error :" + t.getMessage());

            }
        });

    }

    public void states(View view) {
        startActivity(new Intent(this,com.example.covid_india.states.class));
    }

    public void timeline(View view) {
        startActivity(new Intent(this,com.example.covid_india.timeline.class));


    }

    public void tips(){
        String[] name = {"Wash Your Hands frequently!", "It's a LOCKDOWN! Stay Indoors!", "Stand Against FAKE News", "Do Not Panic!", "Stay Strong!We will get through this!",
        "Help the Elderly" , "Groceries and Essentials will be Supplied ", "Be a true Indian, Help those in need"};

        Random random = new Random();
// you have also handle min to max index
        int index = random.nextInt(name.length);
        tv_tips.setText(name[index]);

    }
}
