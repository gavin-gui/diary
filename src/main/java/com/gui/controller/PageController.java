package com.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guichao on 2017/6/14.
 */
@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping(value = "/{page}")
    public String page(@PathVariable String page) {
        return page;
    }

    @GetMapping(value = {"/","index","home"})
    public String home() {
        return "index";
    }

}
