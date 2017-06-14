package com.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by guichao on 2017/6/14.
 */
@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String page(@PathVariable String page) {
        return page;
    }

}
