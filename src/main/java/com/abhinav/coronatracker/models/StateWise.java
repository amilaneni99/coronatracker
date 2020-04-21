package com.abhinav.coronatracker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class StateWise implements Serializable {
    @JsonProperty("statenotes")
    private String stateNotes;

    @JsonProperty("recovered")
    private String recovered;

    @JsonProperty("deltadeaths")
    private String deltaDeaths;

    @JsonProperty("deltarecovered")
    private String deltaRecovered;

    @JsonProperty("active")
    private String active;

    @JsonProperty("deltaconfirmed")
    private String deltaConfirmed;

    @JsonProperty("state")
    private String stateName;

    @JsonProperty("statecode")
    private String stateCode;

    @JsonProperty("confirmed")
    private String confirmed;

    @JsonProperty("deaths")
    private String deaths;

    @JsonProperty("lastupdatedtime")
    private String lastUpdatedTime;

    public String getStateNotes() {
        return stateNotes;
    }

    public void setStateNotes(String stateNotes) {
        this.stateNotes = stateNotes;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeltaDeaths() {
        return deltaDeaths;
    }

    public void setDeltaDeaths(String deltaDeaths) {
        this.deltaDeaths = deltaDeaths;
    }

    public String getDeltaRecovered() {
        return deltaRecovered;
    }

    public void setDeltaRecovered(String deltaRecovered) {
        this.deltaRecovered = deltaRecovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeltaConfirmed() {
        return deltaConfirmed;
    }

    public void setDeltaConfirmed(String deltaConfirmed) {
        this.deltaConfirmed = deltaConfirmed;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
