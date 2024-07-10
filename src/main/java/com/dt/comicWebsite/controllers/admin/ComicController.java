package com.dt.comicWebsite.controllers.admin;

import com.dt.comicWebsite.models.Comic;
import com.dt.comicWebsite.servies.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/comics")
public class ComicController {
    @Autowired
    private ComicService comicService;
    @GetMapping({"", "/"})
    public String showComicList(Model model) {
        List<Comic> comics = comicService.getAll();
        model.addAttribute("comics", comics);
        return "admin/comic/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("comic", new Comic());
        return "admin/comic/createComic";
    }

    @PostMapping("/create")
    public String createComic(@ModelAttribute Comic comic) {
        comicService.create(comic);
        return "redirect:/admin/comics";
    }
}
