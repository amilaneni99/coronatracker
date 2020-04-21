package com.abhinav.coronatracker.services;

import com.abhinav.coronatracker.models.news.statenews.GoogleNewsModel;

import java.io.IOException;
import java.util.List;

public interface GoogleNewsService {
    List<GoogleNewsModel> getArticles(String stateName) throws IOException, InterruptedException;
}
