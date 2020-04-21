package com.abhinav.coronatracker.models.testing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class StateTestData implements Serializable {
    @JsonProperty("totaltested")
    private String totalTested;

    @JsonProperty("state")
    private String stateName;

    @JsonProperty("source")
    private String sourceURL;

    @JsonProperty("updatedon")
    private String lastUpdated;

    private String negative;

    private String numventilators;

    private String numicubeds;

    private String totalpeoplereleasedfromquarantine;

    private String numcallsstatehelpline;

    private String totalpeopleinquarantine;

    private String unconfirmed;

    private String testsperthousand;

    private String numisolationbeds;

    private String positive;

    private String source2;

    private String positiveratebytests;

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getNumventilators() {
        return numventilators;
    }

    public void setNumventilators(String numventilators) {
        this.numventilators = numventilators;
    }

    public String getNumicubeds() {
        return numicubeds;
    }

    public void setNumicubeds(String numicubeds) {
        this.numicubeds = numicubeds;
    }

    public String getTotalpeoplereleasedfromquarantine() {
        return totalpeoplereleasedfromquarantine;
    }

    public void setTotalpeoplereleasedfromquarantine(String totalpeoplereleasedfromquarantine) {
        this.totalpeoplereleasedfromquarantine = totalpeoplereleasedfromquarantine;
    }

    public String getNumcallsstatehelpline() {
        return numcallsstatehelpline;
    }

    public void setNumcallsstatehelpline(String numcallsstatehelpline) {
        this.numcallsstatehelpline = numcallsstatehelpline;
    }

    public String getTotalpeopleinquarantine() {
        return totalpeopleinquarantine;
    }

    public void setTotalpeopleinquarantine(String totalpeopleinquarantine) {
        this.totalpeopleinquarantine = totalpeopleinquarantine;
    }

    public String getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(String unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public String getTestsperthousand() {
        return testsperthousand;
    }

    public void setTestsperthousand(String testsperthousand) {
        this.testsperthousand = testsperthousand;
    }

    public String getNumisolationbeds() {
        return numisolationbeds;
    }

    public void setNumisolationbeds(String numisolationbeds) {
        this.numisolationbeds = numisolationbeds;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getSource2() {
        return source2;
    }

    public void setSource2(String source2) {
        this.source2 = source2;
    }

    public String getPositiveratebytests() {
        return positiveratebytests;
    }

    public void setPositiveratebytests(String positiveratebytests) {
        this.positiveratebytests = positiveratebytests;
    }

    public String getTotalTested() {
        return totalTested;
    }

    public void setTotalTested(String totalTested) {
        this.totalTested = totalTested;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
