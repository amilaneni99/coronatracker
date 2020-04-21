package com.abhinav.coronatracker.services.impl;

import com.abhinav.coronatracker.models.testing.StateTestData;
import com.abhinav.coronatracker.models.testing.TestingAPI;
import com.abhinav.coronatracker.services.StateTestingService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StateTestingServiceImpl implements StateTestingService {

    List<StateTestData> stateTestDataList = new ArrayList<>();
    HashMap<String,String> map = new HashMap<>();
    HashMap<String,String> refMap = new HashMap<>();
    private static String DATA_URL = "https://api.covid19india.org/state_test_data.json";

    @Override
    public List<StateTestData> getStateTestData() {
        return stateTestDataList;
    }

    @Override
    public HashMap<String, String> getTestMap() {
        return map;
    }

    @Override
    public HashMap<String, String> getRefMap() {
        return refMap;
    }


    @Override
    @Scheduled(cron = "0 0 */24 * * *")
    @PostConstruct
    public void fetchTestData() throws IOException, InterruptedException, ParseException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser jsonParser = new JSONParser();
        org.json.simple.JSONObject jsonObject = (JSONObject) jsonParser.parse(httpResponse.body());
        ObjectMapper objectMapper = new ObjectMapper();
        TestingAPI testData = objectMapper.readValue(jsonObject.toString(),TestingAPI.class);
        for (int i=0; i<testData.getStateTestData().length-1;i++){
            if (i != (testData.getStateTestData().length)-2){
                StateTestData stateTemp1 = testData.getStateTestData()[i];
                StateTestData stateTemp2 = testData.getStateTestData()[i+1];
                if (!(stateTemp1.getStateName().equals(stateTemp2.getStateName()))){
                    this.stateTestDataList.add(stateTemp1);
                }else{
                    if(!stateTemp2.getTotalTested().equals("0")){
                        this.stateTestDataList.add(stateTemp1);
                    }
                }
            }else{
                StateTestData stateTemp1 = testData.getStateTestData()[i];
                StateTestData stateTemp2 = testData.getStateTestData()[i+1];
                if (!stateTemp1.getStateName().equals(stateTemp2.getStateName())){
                    this.stateTestDataList.add(stateTemp1);
                    this.stateTestDataList.add(stateTemp2);
                }
            }
        }

        for (StateTestData stateTestData: this.stateTestDataList){
            if (!map.containsKey(stateTestData.getStateName())){
                map.put(stateTestData.getStateName(),stateTestData.getTotalTested());
            }
            if (!refMap.containsKey(stateTestData.getStateName())){
                if (stateTestData.getSourceURL().startsWith("https://t.me/")){
                    refMap.put(stateTestData.getStateName(),"https://www.mohfw.gov.in/");
                }else{
                    refMap.put(stateTestData.getStateName(),stateTestData.getSourceURL());
                }
            }
        }
    }
}
