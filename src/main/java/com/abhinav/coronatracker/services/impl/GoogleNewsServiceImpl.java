package com.abhinav.coronatracker.services.impl;

import com.abhinav.coronatracker.models.news.statenews.GoogleNewsModel;
import com.abhinav.coronatracker.services.GoogleNewsService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleNewsServiceImpl implements GoogleNewsService {
    List<GoogleNewsModel> newsArticles = new ArrayList<>();

    @Override
    public List<GoogleNewsModel> getArticles(String stateName) throws IOException, InterruptedException {
        newsArticles.clear();
        String state = stateName.replaceAll("\\s+","%20");
        String tUrl = "https://news.google.com/search?q="+state+"%20Coronavirus";
        Connection connection = Jsoup.connect(tUrl);
        connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36");
        connection.referrer(tUrl);
        Document document = connection.get();
        Elements articles = document.select("div[jscontroller='d0DtYd']");
        articles.addAll(document.select("div[jslog='93789']"));
        int k=0;
        for(Element article: articles){
            if(k==20){
                break;
            }
            k+=1;
            Element url = article.select("a[target='_blank']").first();
            String imgUrl = (url.selectFirst("img") != null)? url.selectFirst("img").attr("src"): "";
//            URL urlTemp = new URL(imgUrl);
//            HttpURLConnection urlConnection = (HttpURLConnection) urlTemp.openConnection();
//            urlConnection.setRequestMethod("GET");
//            urlConnection.connect();
//            if (urlConnection.getResponseCode() == 403) {
//                imgUrl = "";
//            }
            Element title = article.select("a[class='DY5T1d']").first();
            Element time = article.select("time").first();
            Element source = article.select("a[class='wEwyrc AVN2gc uQIVzc Sksgp']").first();
            String link = "https://news.google.com"+url.attr("href").substring(1);
            GoogleNewsModel googleNewsModel = new GoogleNewsModel(link,title.text(),source.text(),imgUrl,time.text());
            newsArticles.add(googleNewsModel);
        }
        return newsArticles;
    }
}
