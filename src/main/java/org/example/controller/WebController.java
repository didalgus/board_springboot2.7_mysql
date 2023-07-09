package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("/")
    public String getLoignForm() {
        return "/index";
    }

//    @GetMapping("/login")
//    public String getLoignForm() {
//        return "/login/form";
//    }
//
//    @GetMapping("/join")
//    public String getJoinForm() {
//        return "/join/form";
//    }

}
