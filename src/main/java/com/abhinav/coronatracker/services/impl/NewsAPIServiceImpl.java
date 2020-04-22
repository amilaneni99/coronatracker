package com.abhinav.coronatracker.services.impl;

import com.abhinav.coronatracker.models.news.Articles;
import com.abhinav.coronatracker.models.news.NewsModel;
import com.abhinav.coronatracker.services.NewsAPIService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NewsAPIServiceImpl implements NewsAPIService {

    private List<Articles> articles = new ArrayList<>();
    private int totalResults;
    private static String NEWS_URL = "http://newsapi.org/v2/top-headlines?q=coronavirus&country=in&apiKey=YOUR_API_KEY";

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }


    @Override
    @Scheduled(cron = "0 */20 * * * *")
    @PostConstruct
    public void fetchNews() throws IOException, InterruptedException, ParseException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(NEWS_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser jsonParser = new JSONParser();
        org.json.simple.JSONObject jsonObject = (JSONObject) jsonParser.parse(httpResponse.body());
        ObjectMapper objectMapper = new ObjectMapper();
        NewsModel newsModel = objectMapper.readValue(jsonObject.toString(),NewsModel.class);
        this.articles = Arrays.asList(newsModel.getArticles());
        for (Articles article: this.articles){
            if (article.getAuthor() == null){
                URL url = new URL(article.getUrl());
                if (url.getHost().startsWith("www.")){
                    if (url.getHost().endsWith(".com")){
                        String temp = url.getHost().substring(4,url.getHost().length()-4);
                        article.setAuthor(temp.substring(0,1).toUpperCase()+temp.substring(1));
                    }else{
                        article.setAuthor("");
                    }
                }else{
                    article.setAuthor("");
                }
            }
        }
        this.totalResults = newsModel.getTotalResults();
    }
}
