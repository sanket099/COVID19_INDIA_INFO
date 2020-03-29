package com.example.covid_india;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class districts extends AppCompatActivity {
    TextView tv_dist_name;
    dists dists;
    String s;
    String cases;
    String k;
    int i;
    recycler_adapter_district adapter_district;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districts);

        tv_dist_name = findViewById(R.id.tv_dist_name);
        //Statename s = new Statename();

        dists = new dists();
        recyclerView = findViewById(R.id.recycler_districts);

        get();

    }

    public void get(){
        Call<String> call = retrofit_client.getInstance().getapi().strings();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String name = getIntent().getStringExtra("name");


                try {
                    String jsonresponse = response.body();
                    assert jsonresponse != null;
                    JSONObject jsonObject = new JSONObject(jsonresponse);
                    Iterator<String> keys = jsonObject.keys();

                    while(keys.hasNext()) {
                        String key = keys.next();
                        if (jsonObject.get(key) instanceof JSONObject) {
                            //System.out.println((key) + " : object");
                            assert name != null;
                            if(name.equals(key)){
                                tv_dist_name.setText("Districts");
                                s = ((JSONObject) jsonObject.get(key)).toString();
                                //k = key;

                                break;

                            }
                            // do something with jsonObject here
                        }
                    }
                    ArrayList<String> arrayList_districts = new ArrayList<>();
                    JSONArray ca = new JSONArray();
                    JSONArray array = new JSONArray();
                    JSONObject obj1 = new JSONObject(s);
                    //System.out.println(s+" :is this it ");
                    JSONObject obj2 = obj1.getJSONObject("districtData");
                    Iterator<String> keys2 = obj2.keys();
                    while (keys2.hasNext()){
                        String key2 = keys2.next();
                        if(obj2.get(key2) instanceof JSONObject){
                            //System.out.println("case: " + obj2.get(key2)); // stores the confirmed cases data objects
                            //System.out.println("dists : " + key2);
                            cases = ((JSONObject) obj2.get(key2)).toString();
                            JSONObject job = (JSONObject) obj2.get(key2);
                            ca.put(job);
                            array.put(job);

                            arrayList_districts.add(key2);
                            //k = key2;
                        }
                    }
                    //System.out.println("case : "+ ca );
                    //System.out.println("array : "+arrayList_districts); // stores the names of districts
                    //JSONObject objarray = new JSONObject(ca.toString());
                    //JSONArray array = obj1.getJSONArray(k);
                    //JSONArray array = new JSONArray();
                    //array.put();
                    //array.put(objarray.get("lastupdatedtime"));
                    //System.out.println("casess : " + array.toString());

                    ArrayList<model_dist> model_dists = new ArrayList<>();
                    for(i=0;i<array.length();i++){
                        model_dist modelDist = new model_dist();
                        JSONObject dataobj = array.getJSONObject(i);
                        modelDist.setConfirmed(dataobj.getString("confirmed"));
                        modelDist.setLastupdatedtime(dataobj.getString("lastupdatedtime"));
                        model_dists.add(modelDist);

                    }
                    //System.out.println("array : " + model_dists);

                    adapter_district = new recycler_adapter_district(districts.this,arrayList_districts,model_dists);
                    recyclerView.setAdapter(adapter_district);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


                    //assert array != null;
                    //System.out.println("array : "+ array.toString());



                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("error : " + e.getMessage());
                    Toast.makeText(districts.this,"error",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}
