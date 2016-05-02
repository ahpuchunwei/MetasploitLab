package com.jxnu.app.controller;

import com.jxnu.app.dao.NewsDao;
import com.jxnu.app.model.News;
import com.jxnu.app.model.User;
import com.jxnu.app.service.NewsService;
import com.jxnu.app.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by puchunwei on 16/5/1.
 */
@Controller
public class IndexController {
    @Autowired
    NewsService newsService;
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("Index/index/index");
        List<News> newsList = newsService.findAll();
        modelAndView.addObject("NewsList", newsList);

        return modelAndView;
    }

    @RequestMapping("/courseList")
    public ModelAndView courseList() {
        ModelAndView modelAndView = new ModelAndView("Index/index/courseList");
        return modelAndView;
    }

    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("Index/index/test");
        return modelAndView;
    }

    @RequestMapping("/testList")
    public ModelAndView testList() {
        ModelAndView modelAndView = new ModelAndView("Index/index/testList");
        return modelAndView;
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> data) throws IOException {

        System.out.println(data.get("username"));
        System.out.println(data.get("password"));

        User user = new User();
        user.setUserName(data.get("username"));
        user.setPassword(data.get("password"));

        User user1 = userService.checkUserNameAndPassword(user);

        HttpSession session = request.getSession();

        if (user1 != null) {
            System.out.println("登录成功");
            session.setAttribute("user", user);
            response.sendRedirect("http://localhost:8080/index.htm");
        } else {
            System.out.println("登录失败");
            response.sendRedirect("http://localhost:8080/index.htm");
        }
        return;
    }

    @RequestMapping("/logout")
    public void logout(@RequestParam Map<String, String> data, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // TODO 移除Cookie
        request.getSession().removeAttribute("user");
        response.sendRedirect("http://localhost:8080/index.htm");
    }

}
