package com.abhinav.coronatracker.models.testing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TestingAPI implements Serializable {
    @JsonProperty("states_tested_data")
    private StateTestData[] stateTestData;

    public StateTestData[] getStateTestData() {
        return stateTestData;
    }

    public void setStateTestData(StateTestData[] stateTestData) {
        this.stateTestData = stateTestData;
    }
}
