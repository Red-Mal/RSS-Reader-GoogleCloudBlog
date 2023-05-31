package org.sid.rssreaderclient.utils;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.sid.rssreaderclient.entities.NewsArticle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RSSReaderUtil {

    public static List<NewsArticle> read(String feedUrl) throws IOException, FeedException, MalformedURLException {
        URL feedSource = new URL(feedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        Iterator itr = feed.getEntries().iterator();
        List<NewsArticle> results = new ArrayList<>();
        while (itr.hasNext()) {
            SyndEntry syndEntry = (SyndEntry) itr.next();
            results.add(mapToArticle(syndEntry));
        }

        return results;
    }

    private static NewsArticle mapToArticle(SyndEntry syndEntry) {
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setTitle(syndEntry.getTitle());
        newsArticle.setPublishedDate(syndEntry.getPublishedDate().toString());
        newsArticle.setImgUrl("");
        newsArticle.setLink(syndEntry.getLink());
        return newsArticle;
    }
}