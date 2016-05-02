package com.jxnu.app.controller;

import com.jxnu.app.model.News;
import com.jxnu.app.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by puchunwei on 16/5/1.
 */
@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping("/newsManage")
    public ModelAndView newsManage() {
        ModelAndView modelAndView = new ModelAndView("/Admin/newsManage/index");
        List<News> newsList = newsService.findAll();
        modelAndView.addObject("NewsList", newsList);
        return modelAndView;
    }

    @RequestMapping("/addNewsUI")
    public ModelAndView addNewsUI() {
        ModelAndView modelAndView = new ModelAndView("/Admin/newsManage/add");
        return modelAndView;
    }

    @RequestMapping("/addNews")
    public ModelAndView addUser(@RequestParam Map<String, String> data) {
        News news = new News();
        news.setTitle(data.get("title"));
        news.setContent(data.get("content"));
        newsService.addNews(news);

        ModelAndView modelAndView = newsManage();
        return modelAndView;
    }

    @RequestMapping("/deleteNews")
    public ModelAndView deleteNews(@RequestParam Map<String, String> data) {
        Long newsId = Long.parseLong(data.get("id"));
        newsService.deleteNews((newsId));
        ModelAndView modelAndView = newsManage();
        return modelAndView;
    }

    @RequestMapping("/editNewsUI")
    public ModelAndView editNewsUI(@RequestParam Map<String, String> data) {
        Long newsId = Long.parseLong(data.get("id"));
        News news = newsService.queryById((newsId));
        ModelAndView modelAndView = new ModelAndView("/Admin/newsManage/edit");
        modelAndView.addObject("news", news);
        return modelAndView;

    }

    @RequestMapping("/editNews")
    public ModelAndView editNews(@RequestParam Map<String, String> data) {
        Long newsId = Long.parseLong(data.get("id"));
        News news = newsService.queryById((newsId));
        news.setTitle(data.get("title"));
        news.setContent(data.get("content"));
        newsService.updateNews(news);
        ModelAndView modelAndView = newsManage();
        return modelAndView;
    }

}
