package org.example.controller;

import org.example.entity.BoardEntity;
import org.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String main() {
        return "redirect:/board";
    }

    @GetMapping("/board")
    public String board(Model model) {
        List<BoardEntity> list = boardService.getBoardList(null);
        model.addAttribute("lists", list);
        return "/board";
    }

    @GetMapping("/board/form")
    public String boardForm() {
        return "boardForm";
    }

}
