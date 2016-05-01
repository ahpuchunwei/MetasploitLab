package com.jxnu.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by puchunwei on 16/5/1.
 */
@Controller
public class UserController {

    @RequestMapping("/Test/helloWorld")
    @ResponseBody
    public String Test() {
        System.out.println("helloWorld");
        return "Hello,World!";
    }

    @RequestMapping("/Lab/hll")
    @ResponseBody
    public String Lab() {
        System.out.println("hellohll");
        return "hellohll";
    }

}
