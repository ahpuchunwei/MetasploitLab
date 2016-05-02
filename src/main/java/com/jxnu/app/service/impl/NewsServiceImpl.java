package com.jxnu.app.service.impl;

import com.jxnu.app.dao.NewsDao;
import com.jxnu.app.model.News;
import com.jxnu.app.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    public void addNews(News news) { newsDao.addNews(news);}

    public List<News> findAll() { return newsDao.findall();}

    public void deleteNews(Long id) { newsDao.deleteNews(id);}

    public News queryById(Long id) {
        return newsDao.queryById(id);
    }

    public void updateNews(News news) { newsDao.updateNews(news);}
}
