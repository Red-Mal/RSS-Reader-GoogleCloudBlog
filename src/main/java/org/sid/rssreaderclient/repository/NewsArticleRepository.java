package org.sid.rssreaderclient.repository;

import org.sid.rssreaderclient.entities.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NewsArticleRepository extends JpaRepository<NewsArticle,Long> {
}
