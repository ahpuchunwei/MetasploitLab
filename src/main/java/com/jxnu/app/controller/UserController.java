package com.jxnu.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by puchunwei on 16/5/1.
 */
@Controller
public class UserController {

    @RequestMapping("/userManage")
    public ModelAndView userManage() {
        ModelAndView modelAndView = new ModelAndView("/Admin/userManage/index");
        return modelAndView;
    }

    @RequestMapping("/addUserUI")
    public ModelAndView addUserUI() {
        ModelAndView modelAndView = new ModelAndView("/Admin/userManage/add");
        return modelAndView;
    }
}
