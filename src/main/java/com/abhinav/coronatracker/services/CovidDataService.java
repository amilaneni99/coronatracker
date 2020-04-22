package com.abhinav.coronatracker.services;

import com.abhinav.coronatracker.models.CaseTimeSeries;
import com.abhinav.coronatracker.models.StateCode;
import com.abhinav.coronatracker.models.StateWise;
import com.abhinav.coronatracker.models.Tested;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface CovidDataService {
    void fetchAllData() throws IOException, InterruptedException, ParseException, java.text.ParseException;
    List<StateWise> getStateWiseList();
    List<StateCode> getStateNames();
    List<CaseTimeSeries> getCaseTimeSeriesList();
    List<Tested> getTestedList();
    String getTimeUpdated();
}
