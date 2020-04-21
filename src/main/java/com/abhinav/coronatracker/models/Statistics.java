package com.abhinav.coronatracker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Statistics implements Serializable {

    @JsonProperty("cases_time_series")
    private CaseTimeSeries[] caseTimeSeries;

    @JsonProperty("tested")
    private Tested[] tested;

    @JsonProperty("statewise")
    private StateWise[] stateWise;

    public CaseTimeSeries[] getCaseTimeSeries() {
        return caseTimeSeries;
    }

    public void setCaseTimeSeries(CaseTimeSeries[] caseTimeSeries) {
        this.caseTimeSeries = caseTimeSeries;
    }

    public Tested[] getTested() {
        return tested;
    }

    public void setTested(Tested[] tested) {
        this.tested = tested;
    }

    public StateWise[] getStateWise() {
        return stateWise;
    }

    public void setStateWise(StateWise[] stateWise) {
        this.stateWise = stateWise;
    }
}
