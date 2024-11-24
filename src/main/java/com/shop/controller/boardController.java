package com.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class boardController {
    @RequestMapping("/board/list")
    public String boardList(){
        return "board/boardList";
    }
}
