package org.example.controller;

import org.example.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/board")
    public String board() {
        return "/board";
    }

    @GetMapping("/admin/**")
    public String admin(Model model) {

        List<UserEntity> users = userService.userList();
        model.addAttribute("users", users);

        return "admin";
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
