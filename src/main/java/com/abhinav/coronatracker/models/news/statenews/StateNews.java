package com.abhinav.coronatracker.models.news.statenews;

import java.util.ArrayList;
import java.util.List;

public class StateNews {
    List<GoogleNewsModel> googleArticles = new ArrayList<>();

    public List<GoogleNewsModel> getGoogleArticles() {
        return googleArticles;
    }

    public void setGoogleArticles(List<GoogleNewsModel> googleArticles) {
        this.googleArticles = googleArticles;
    }

}
