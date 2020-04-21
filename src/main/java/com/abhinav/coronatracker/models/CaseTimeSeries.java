package com.abhinav.coronatracker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CaseTimeSeries implements Serializable {
    @JsonProperty("date")
    private String date;

    @JsonProperty("dailyrecovered")
    private String dailyRecovered;

    @JsonProperty("totalconfirmed")
    private String totalConfirmed;

    @JsonProperty("totaldeceased")
    private String totalDeceased;

    @JsonProperty("dailydeceased")
    private String dailyDeceased;

    @JsonProperty("totalrecovered")
    private String totalRecovered;

    @JsonProperty("dailyconfirmed")
    private String dailyConfirmed;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(String dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getTotalDeceased() {
        return totalDeceased;
    }

    public void setTotalDeceased(String totalDeceased) {
        this.totalDeceased = totalDeceased;
    }

    public String getDailyDeceased() {
        return dailyDeceased;
    }

    public void setDailyDeceased(String dailyDeceased) {
        this.dailyDeceased = dailyDeceased;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(String dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }
}
