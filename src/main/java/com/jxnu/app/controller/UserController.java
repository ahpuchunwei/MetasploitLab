package com.jxnu.app.controller;

import com.jxnu.app.model.User;
import com.jxnu.app.service.UserService;
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
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/userManage")
    public ModelAndView userManage() {
        ModelAndView modelAndView = new ModelAndView("/Admin/userManage/index");
        List<User> userList = userService.findAll();
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping("/addUserUI")
    public ModelAndView addUserUI() {
        ModelAndView modelAndView = new ModelAndView("/Admin/userManage/add");
        return modelAndView;
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(@RequestParam Map<String, String> data) {
        User user = new User();
        user.setUserName(data.get("username"));
        user.setPassword(data.get("password"));
        userService.addUser(user);

        ModelAndView modelAndView = userManage();
        return modelAndView;
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(@RequestParam Map<String, String> data) {
        Long userId = Long.parseLong(data.get("id"));
        userService.deleteUser(userId);
        ModelAndView modelAndView = userManage();
        return modelAndView;
    }

    @RequestMapping("/editUserUI")
    public ModelAndView editUserUI(@RequestParam Map<String, String> data) {
        Long userId = Long.parseLong(data.get("id"));
        User user = userService.queryById(userId);
        ModelAndView modelAndView = new ModelAndView("/Admin/userManage/edit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/editUser")
    public ModelAndView editUser(@RequestParam Map<String, String> data) {
        Long userId = Long.parseLong(data.get("id"));
        User user = userService.queryById(userId);
        user.setUserName(data.get("username"));
        user.setPassword(data.get("password"));
        userService.updateUser(user);
        ModelAndView modelAndView = userManage();
        return modelAndView;
    }

}
