package org.sid.rssreaderclient;

import com.sun.syndication.io.FeedException;
import org.sid.rssreaderclient.entities.NewsArticle;
import org.sid.rssreaderclient.repository.NewsArticleRepository;
import org.sid.rssreaderclient.utils.RSSReaderUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class RssReaderClientApplication {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, FeedException, FeedException {

            SpringApplication.run(RssReaderClientApplication.class, args);

       /* URL feedSource = new URL("https://cloudblog.withgoogle.com/rss/");
        List<String> targetFeedsList = List.of("https://cloudblog.withgoogle.com/rss/");

        for (String url : targetFeedsList) {
            List<NewsArticle> results = RSSReaderUtil.read(url);
            System.out.println("url : " + url);
            results.stream().forEach(a -> System.out.println(a.toString()));
            System.out.println("==========");
        }*/
    }

    @Bean
    CommandLineRunner start(NewsArticleRepository newsArticleRepository) {
        return args -> {
            URL feedSource = new URL("https://cloudblog.withgoogle.com/rss/");
            List<String> targetFeedsList = List.of("https://cloudblog.withgoogle.com/rss/");

            for (String url : targetFeedsList) {
                List<NewsArticle> results = RSSReaderUtil.read(url);

                System.out.println("url : " + url);
                results.stream().forEach(newsArticle -> {
                    System.out.println(newsArticle.toString());
                    newsArticleRepository.save(new NewsArticle(null,newsArticle.getTitle(),newsArticle.getLink(),newsArticle.getImgUrl(),newsArticle.getCategories(),newsArticle.getPublishedDate()));

                    }
                );

            }

        };
    }
}