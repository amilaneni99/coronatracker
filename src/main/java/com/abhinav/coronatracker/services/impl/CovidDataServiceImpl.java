package com.abhinav.coronatracker.services.impl;

import com.abhinav.coronatracker.models.*;
import com.abhinav.coronatracker.services.CovidDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Service
public class CovidDataServiceImpl implements CovidDataService {

    private static String DATA_URL = "https://api.covid19india.org/data.json";

    public List<StateWise> stateWiseList = new ArrayList<>();
    public List<StateCode> stateNames = new ArrayList<>();
    public List<Tested> testedList = new ArrayList<>();
    public List<CaseTimeSeries> caseTimeSeriesList = new ArrayList<>();

    public List<StateWise> getStateWiseList() {
        return stateWiseList;
    }

    @Override
    public List<StateCode> getStateNames() {
        return stateNames;
    }

    public void setStateWiseList(List<StateWise> stateWiseList) {
        this.stateWiseList = stateWiseList;
    }

    public List<Tested> getTestedList() {
        return testedList;
    }

    public void setTestedList(List<Tested> testedList) {
        this.testedList = testedList;
    }

    public List<CaseTimeSeries> getCaseTimeSeriesList() {
        return caseTimeSeriesList;
    }

    public void setCaseTimeSeriesList(List<CaseTimeSeries> caseTimeSeriesList) {
        this.caseTimeSeriesList = caseTimeSeriesList;
    }


    @Override
    @Scheduled(cron = "0 0 */3 * * *")
    @PostConstruct
    @Cacheable("allData")
    public void fetchAllData() throws IOException, InterruptedException, ParseException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser jsonParser = new JSONParser();
        org.json.simple.JSONObject jsonObject = (JSONObject) jsonParser.parse(httpResponse.body());
        ObjectMapper objectMapper = new ObjectMapper();
        Statistics statistics = objectMapper.readValue(jsonObject.toString(),Statistics.class);
        this.caseTimeSeriesList = Arrays.asList(statistics.getCaseTimeSeries());
        this.stateWiseList = Arrays.asList(statistics.getStateWise());
        this.testedList = Arrays.asList(statistics.getTested());
        for(StateWise stateWise:stateWiseList){
            this.stateNames.add(new StateCode(stateWise.getStateName(),stateWise.getStateCode()));
        }
        this.stateNames.sort(Comparator.comparing(StateCode::getStateName));
    }
}
