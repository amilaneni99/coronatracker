package com.abhinav.coronatracker.services;

import com.abhinav.coronatracker.models.testing.StateTestData;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface StateTestingService {
    List<StateTestData> getStateTestData();
    HashMap<String,String> getTestMap();
    HashMap<String,String> getRefMap();
    void fetchTestData() throws IOException, InterruptedException, ParseException;
}
