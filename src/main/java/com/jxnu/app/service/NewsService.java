package com.jxnu.app.service;

import com.jxnu.app.model.News;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface NewsService {

    void addNews(News news);

    List<News> findAll();

    void deleteNews(Long id);

   News queryById(Long id);

    void updateNews(News news);
}
