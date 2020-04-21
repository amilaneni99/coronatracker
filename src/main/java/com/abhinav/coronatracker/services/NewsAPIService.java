package com.abhinav.coronatracker.services;

import com.abhinav.coronatracker.models.news.Articles;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface NewsAPIService {
    List<Articles> getArticles();
    int getTotalResults();
    void fetchNews() throws IOException, InterruptedException, ParseException;
}
