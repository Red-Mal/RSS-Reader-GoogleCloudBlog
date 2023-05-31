package org.sid.rssreaderclient.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor
@Data
public class NewsArticle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;
    private String imgUrl;
    @Transient
    private List<String> categories;
    private String publishedDate;


    @Override
    public String toString() {
        return "NewsArticle{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", categories=" + categories +
                ", publishedDate='" + publishedDate + '\'' +
                '}';
    }
}