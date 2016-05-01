package com.jxnu.app.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by puchunwei on 16/5/1.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView("Index/index/index");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam Map<String, String> data) {
        ModelAndView modelAndView = new ModelAndView("Index/index/index");

        System.out.println(data.get("username"));
        System.out.println(data.get("password"));
        if (StringUtils.equals("admin", data.get("username")) && StringUtils.equals("admin", data.get("password"))) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        return modelAndView;
    }

}
