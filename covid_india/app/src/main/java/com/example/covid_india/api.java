package com.example.covid_india;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api {

    @GET("data.json")//endpoint

    Call<cases> latest( //response we shall get



    );
    @GET("data.json")//endpoint

    Call<String> region( //response we shall get



    );
    @GET("state_district_wise.json")
    Call<dists> dis ();


    @GET("state_district_wise.json")
    Call<String> strings ();




}
