package com.abhinav.coronatracker.models.news;

import java.io.Serializable;

public class NewsModel implements Serializable {
    private String status;
    private int totalResults;
    private Articles[] articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }
}
