package com.abhinav.coronatracker.services.impl;

import com.abhinav.coronatracker.models.*;
import com.abhinav.coronatracker.services.CovidDataService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CovidDataServiceImpl implements CovidDataService {

    private static String DATA_URL = "https://api.covid19india.org/data.json";

    DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat dateFormat2 = new SimpleDateFormat("hh:mm aa");

    public List<StateWise> stateWiseList = new ArrayList<>();
    public List<StateCode> stateNames = new ArrayList<>();
    public List<Tested> testedList = new ArrayList<>();
    public List<CaseTimeSeries> caseTimeSeriesList = new ArrayList<>();
    public String timeUpdated;

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

    @Override
    public String getTimeUpdated() {
        return timeUpdated;
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
    @PostConstruct
    @Scheduled(cron = "0 */30 * * * *")
    public void fetchAllData() throws IOException, InterruptedException, ParseException {
        dateFormat1.setTimeZone(TimeZone.getTimeZone("IST"));
        dateFormat2.setTimeZone(TimeZone.getTimeZone("IST"));
        this.timeUpdated = dateFormat1.format(new Date())+" at "+dateFormat2.format(new Date());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser jsonParser = new JSONParser();
        org.json.simple.JSONObject jsonObject = (JSONObject) jsonParser.parse(httpResponse.body());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
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
