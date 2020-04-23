package com.abhinav.coronatracker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Tested implements Serializable {
    @JsonProperty("testsconductedbyprivatelabs")
    private String testsConductedByPrivateLabs;

    @JsonProperty("totalsamplestested")
    private String totalSamplesTested;

    @JsonProperty("positivecasesfromsamplesreported")
    private String positiveCasesFromSamplesReported;

    @JsonProperty("samplereportedtoday")
    private String sampleReportedToday;

    @JsonProperty("source")
    private String source;

    @JsonProperty("updatetimestamp")
    private String updateTimeStamp;

    @JsonProperty("testpositivityrate")
    private String testPositivityRate;

    @JsonProperty("totalindividualstested")
    private String totalIndividualsTested;

    @JsonProperty("totalpositivecases")
    private String totalPositiveCases;

    public String getTestPositivityRate() {
        return testPositivityRate;
    }

    public void setTestPositivityRate(String testPositivityRate) {
        this.testPositivityRate = testPositivityRate;
    }

    public String getTestsConductedByPrivateLabs() {
        return testsConductedByPrivateLabs;
    }

    public void setTestsConductedByPrivateLabs(String testsConductedByPrivateLabs) {
        this.testsConductedByPrivateLabs = testsConductedByPrivateLabs;
    }

    public String getTotalSamplesTested() {
        return totalSamplesTested;
    }

    public void setTotalSamplesTested(String totalSamplesTested) {
        this.totalSamplesTested = totalSamplesTested;
    }

    public String getPositiveCasesFromSamplesReported() {
        return positiveCasesFromSamplesReported;
    }

    public void setPositiveCasesFromSamplesReported(String positiveCasesFromSamplesReported) {
        this.positiveCasesFromSamplesReported = positiveCasesFromSamplesReported;
    }

    public String getSampleReportedToday() {
        return sampleReportedToday;
    }

    public void setSampleReportedToday(String sampleReportedToday) {
        this.sampleReportedToday = sampleReportedToday;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(String updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public String getTotalIndividualsTested() {
        return totalIndividualsTested;
    }

    public void setTotalIndividualsTested(String totalIndividualsTested) {
        this.totalIndividualsTested = totalIndividualsTested;
    }

    public String getTotalPositiveCases() {
        return totalPositiveCases;
    }

    public void setTotalPositiveCases(String totalPositiveCases) {
        this.totalPositiveCases = totalPositiveCases;
    }
}
