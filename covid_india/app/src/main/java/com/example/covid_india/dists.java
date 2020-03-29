package com.example.covid_india;

import com.google.gson.annotations.SerializedName;

public class dists {

    private String statenames;

    Statename statename;

    public dists() {
    }

    public String getStatenames() {
        return statenames;
    }

    public Statename getStatename() {
        return statename;
    }
}
class Statename {

    districtData districtData;

    public com.example.covid_india.districtData getDistrictData() {
        return districtData;
    }
}
class districtData{
    Dist_name dist_name;

    public Dist_name getDist_name() {
        return dist_name;
    }
}
class Dist_name{
    @SerializedName("confirmed")
    private String confirmed;

    public String getConfirmed() {
        return confirmed;
    }
}
