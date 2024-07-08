package com.dt.comicWebsite.controllers.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/comic")
public class ComicController {

    @GetMapping
    public String index () {
        return "admin/comic/index";
    }
}
