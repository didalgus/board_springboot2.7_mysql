package org.example.controller;

import org.example.entity.BoardEntity;
import org.example.entity.UserEntity;
import org.example.service.BoardService;
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

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String main() {
        return "/main";
    }

    @GetMapping("/board")
    public String board(Model model) {
        List<BoardEntity> list = boardService.getBoardList(null);
        model.addAttribute("list", list);
        return "/board";
    }

    @GetMapping("/board/form")
    public String boardForm() {
        return "boardForm";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<UserEntity> users = userService.userList();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }

    @GetMapping("/sign-out")
    public String signOut() {
        return "sign-out";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "/sign-up";
    }

    @GetMapping("/error/403")
    public String error403() {
        return "error403";
    }

}
