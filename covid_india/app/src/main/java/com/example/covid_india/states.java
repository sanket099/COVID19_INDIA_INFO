package com.example.covid_india;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class states extends AppCompatActivity implements recycler_adapter_states.OnNoteList  {
    RecyclerView recyclerView;
    ArrayList<statewise> arrayList;
    recycler_adapter_states adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);
        recyclerView = findViewById(R.id.recycler_states);
        arrayList = new ArrayList<statewise>();

        Json();
    }

    private void Json() {
        Call<String> call = retrofit_client.getInstance().getapi().region();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                assert response.body() != null;
                //Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.code() == 200) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body();
                        writeRecycler(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                System.out.println("fail" + t.getMessage());

            }
        });
    }

    private void writeRecycler(String response){

        try {
            //getting the whole json object from the response

            JSONObject obj = new JSONObject(response);
            //obj = response.data;


            arrayList = new ArrayList<statewise>();
            //JSONObject object = obj.getJSONObject("data");
            JSONArray dataArray  = obj.getJSONArray("statewise");
            System.out.println("hello");

            for (int i = 1; i < dataArray.length(); i++) {

                statewise modelRecycler = new statewise();
                JSONObject dataobj = dataArray.getJSONObject(i);

                //modelRecycler.setImgURL(dataobj.getString("imgURL"));
                modelRecycler.setDate(dataobj.getString("lastupdatedtime"));
                modelRecycler.setActive(dataobj.getString("active"));
                modelRecycler.setConfirmed(dataobj.getString("confirmed"));
                modelRecycler.setDeaths(dataobj.getString("deaths"));
                modelRecycler.setRecovered(dataobj.getString("recovered"));
                modelRecycler.setState(dataobj.getString("state"));
                //modelRecycler.setDaily_recovered(dataobj.getString("dailyrecovered"));
                arrayList.add(modelRecycler);

            }

            adapter = new recycler_adapter_states(states.this,arrayList, this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));



        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("error" + e.getMessage());
        }

    }

    @Override
    public void OnnoteClick(int position) {
        /*Intent intent = new Intent(states.this, com.example.covid19_india.hospitals_data.class);
        intent.putExtra("selected", modelRecyclerArrayList.get(position).toString());

        intent.putExtra("select", position);
        intent.putExtra("array", modelRecyclerArrayList);
        //intent.putExtra("note",note);

        //intent.getParcelableArrayListExtra("array",arrayList);
        startActivity(intent);*/
        Intent intent = new Intent(states.this,com.example.covid_india.districts.class);
        intent.putExtra("name",arrayList.get(position).getState());
        startActivity(intent);

        Toast.makeText(states.this,arrayList.get(position).getState()+"",Toast.LENGTH_SHORT).show();

    }

}
