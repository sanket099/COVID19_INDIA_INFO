package com.example.covid_india;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class cases {
    @SerializedName("cases_time_series")
    private ArrayList<case_time_series> timeline;
    @SerializedName("statewise")
    private ArrayList<statewise>  statewiseArrayList;

    public cases() {

    }

    public ArrayList<case_time_series> getTimeline() {
        return timeline;
    }

    public ArrayList<statewise> getStatewiseArrayList() {
        return statewiseArrayList;
    }
}
class  case_time_series{

    @SerializedName("dailyconfirmed")
    private String daily_confirmed;
    @SerializedName("dailydeceased")
    private String daily_deceased;
    @SerializedName("dailyrecovered")
    private  String daily_recovered;
    @SerializedName("date")
    private  String date;
    @SerializedName("totalconfirmed")
    private String total_confirmed;
    @SerializedName("totaldeceased")
    private  String total_deceased;
    @SerializedName("totalrecovered")
    private  String total_recovered;

    public case_time_series() {
    }

    public String getDaily_confirmed() {
        return daily_confirmed;
    }

    public void setDaily_confirmed(String daily_confirmed) {
        this.daily_confirmed = daily_confirmed;
    }

    public String getDaily_deceased() {
        return daily_deceased;
    }

    public void setDaily_deceased(String daily_deceased) {
        this.daily_deceased = daily_deceased;
    }

    public String getDaily_recovered() {
        return daily_recovered;
    }

    public void setDaily_recovered(String daily_recovered) {
        this.daily_recovered = daily_recovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal_confirmed() {
        return total_confirmed;
    }

    public void setTotal_confirmed(String total_confirmed) {
        this.total_confirmed = total_confirmed;
    }

    public String getTotal_deceased() {
        return total_deceased;
    }

    public void setTotal_deceased(String total_deceased) {
        this.total_deceased = total_deceased;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public void setTotal_recovered(String total_recovered) {
        this.total_recovered = total_recovered;
    }
}
class statewise{

    @SerializedName("active")
    private String active;
    @SerializedName("confirmed")
    private String confirmed;
    @SerializedName("deaths")
    private String deaths;
    @SerializedName("recovered")
    private String recovered;
    @SerializedName("lastupdatedtime")
    private String date;
    @SerializedName("state")
    private String state;

    public statewise() {
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

