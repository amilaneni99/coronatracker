package com.abhinav.coronatracker.models.news.statenews;

public class GoogleNewsModel {
    private String url;
    private String title;
    private String source;
    private String imageUrl;
    private String time;

    public GoogleNewsModel(String url, String title, String source, String imageUrl, String time) {
        this.url = url;
        this.title = title;
        this.source = source;
        this.imageUrl = imageUrl;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
