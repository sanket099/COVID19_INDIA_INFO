package com.example.covid_india;

import com.google.gson.annotations.SerializedName;

public class model_dist {
    @SerializedName("confirmed")
    private String confirmed;
    @SerializedName("lastupdatedtime")
    private String lastupdatedtime;

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    public model_dist() {
    }
}
