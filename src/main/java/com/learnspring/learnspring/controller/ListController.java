package com.learnspring.learnspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ListController {
    @GetMapping("/showList")
    public String showList() {
        return "allList";
    }

    @GetMapping("/showHome")
    public String showHome() {
        return "home";
    }
}
