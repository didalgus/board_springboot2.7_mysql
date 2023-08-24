package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/board")
    public String board() {
        return "/board";
    }

    @GetMapping("/admin/**")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/project")
    public String project() {
        return "/project";
    }

    @GetMapping("/login/form")
    public String getLoignForm() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/error/403")
    public String error403() {
        return "error403";
    }
//
//    @GetMapping("/join")
//    public String getJoinForm() {
//        return "/join/form";
//    }


}
