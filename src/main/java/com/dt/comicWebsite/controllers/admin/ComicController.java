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

    // READ
    @GetMapping({"", "/"})
    public String showComicList(Model model) {
        List<Comic> comics = comicService.getAll();
        model.addAttribute("comics", comics);
        return "admin/comic/index";
    }

    // CREATE
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("comic", new Comic());
        return "admin/comic/createComic";
    }

    @PostMapping("/create")
    public String createComic(@ModelAttribute Comic comic) {
        comicService.save(comic);
        return "redirect:/admin/comics";
    }

    // EDIT
    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        Comic comic = comicService.getById(id).get();
        model.addAttribute("comic", comic);
        return "admin/comic/editComic";
    }

    @PostMapping("/edit")
    public String editComic(@RequestParam int id, @ModelAttribute Comic comic) {
        comic.setId(id);   // đảm bảo id không bị thay đổi
        comicService.save(comic);
        return "redirect:/admin/comics";
    }

    // DELETE
    @GetMapping("/delete")
    public String deleteComic(@RequestParam int id) {
        comicService.delete(id);
        return "redirect:/admin/comics";
    }
}
