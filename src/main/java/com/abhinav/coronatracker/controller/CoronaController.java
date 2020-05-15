package com.abhinav.coronatracker.controller;

import com.abhinav.coronatracker.models.CaseTimeSeries;
import com.abhinav.coronatracker.models.StateWise;
import com.abhinav.coronatracker.models.Tested;
import com.abhinav.coronatracker.models.news.Articles;
import com.abhinav.coronatracker.models.news.statenews.GoogleNewsModel;
import com.abhinav.coronatracker.services.CovidDataService;
import com.abhinav.coronatracker.services.GoogleNewsService;
import com.abhinav.coronatracker.services.NewsAPIService;
import com.abhinav.coronatracker.services.StateTestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CoronaController {

    int visits = 0;

    @Autowired
    CovidDataService covidDataService;

    @Autowired
    NewsAPIService newsAPIService;

    @Autowired
    StateTestingService stateTestingService;

    @Autowired
    GoogleNewsService googleNewsService;

    @GetMapping("/")
    public String index(Model model){
        visits+=1;
        List<StateWise> stateWiseList = covidDataService.getStateWiseList();
        List<Tested> testedList = covidDataService.getTestedList();
        List<CaseTimeSeries> caseTimeSeriesList = covidDataService.getCaseTimeSeriesList();
        model.addAttribute("stateWiseList",stateWiseList.subList(1,stateWiseList.size()-1));
        model.addAttribute("tested",testedList.get(testedList.size()-1).getTotalSamplesTested());
        model.addAttribute("caseTimeSeries",caseTimeSeriesList.subList(caseTimeSeriesList.size()-15,caseTimeSeriesList.size()-1));
        model.addAttribute("nationalStatus",stateWiseList.get(0));
//        model.addAttribute("testMap",stateTestingService.getTestMap());
        model.addAttribute("lastUpdatedTime",stateWiseList.get(0).getLastUpdatedTime());
//        model.addAttribute("refMap",stateTestingService.getRefMap());
        model.addAttribute("states",covidDataService.getStateNames());
        model.addAttribute("timeUpdated",covidDataService.getTimeUpdated());
        System.out.println("Last Updated: "+covidDataService.getTimeUpdated()+"\nVisits: "+visits);
        return "index";
    }

    @GetMapping("/trending")
    public String trending(Model model){
        List<Articles> newsList = newsAPIService.getArticles();
        int totalArticles = newsAPIService.getTotalResults();
        model.addAttribute("articles",newsList);
        model.addAttribute("total",totalArticles);
        return "trending";
    }

    @GetMapping("/states/{stateCode}")
    public String states(@PathVariable String stateCode, Model model) throws IOException, InterruptedException {
        String stateName = "Tamil Nadu";
        for(StateWise stateWise:covidDataService.getStateWiseList()){
            if (stateWise.getStateCode().equals(stateCode)){
                stateName = stateWise.getStateName();
                model.addAttribute("covidData",stateWise);
                break;
            }
        }
        List<GoogleNewsModel> newsArticles = googleNewsService.getArticles(stateName);
        model.addAttribute("articles",newsArticles);
        model.addAttribute("stateName",stateName);
        return "state";
    }

    @RequestMapping(value = "/virus", method = RequestMethod.GET,
            produces = MediaType.IMAGE_PNG_VALUE)

    public void getImage(HttpServletResponse response) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/virus.png");

        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

}
