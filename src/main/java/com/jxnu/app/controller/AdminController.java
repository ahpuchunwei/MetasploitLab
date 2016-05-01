package com.jxnu.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by puchunwei on 16/5/1.
 */
@Controller
public class AdminController {

    @RequestMapping("/Admin/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/Admin/index/index");
        return modelAndView;
    }
}
