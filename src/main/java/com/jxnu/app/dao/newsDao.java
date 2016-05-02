package com.jxnu.app.dao;

import com.jxnu.app.model.News;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface NewsDao {

    void addNews(News news);

    void deleteNews(Long id);

    void updateNews(News news);

    News queryById(Long id);

    List<News> findall();

}
