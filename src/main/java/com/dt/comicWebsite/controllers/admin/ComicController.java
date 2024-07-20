package com.dt.comicWebsite.controllers.admin;

import com.dt.comicWebsite.models.Category;
import com.dt.comicWebsite.models.Comic;
import com.dt.comicWebsite.servies.CategoryService;
import com.dt.comicWebsite.servies.ComicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/comic")
public class ComicController {
    @Autowired
    private ComicService comicService;

    @Autowired
    private CategoryService categoryService;

    // READ
    @GetMapping({"", "/"})
    public String showComicList(Model model) {
        List<Comic> comics = comicService.getAll();
        model.addAttribute("comics", comics);
        return "admin/comic/listComic";
    }

    // CREATE
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("comic", new Comic());
        model.addAttribute("categories", categoryService.getAll());
        return "admin/comic/createComic";
    }

    @PostMapping("/create")
    public String createComic(@ModelAttribute @Valid Comic comic, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "admin/comic/createComic";
        }

        comicService.save(comic);
        return "redirect:/admin/comic";
    }

    // EDIT
    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        Comic comic = comicService.getById(id);
        model.addAttribute("comic", comic);
        model.addAttribute("categories", categoryService.getAll());

        // previously selected categories
        model.addAttribute("selectedCategoryIds", comic.getCategories().stream()
                .map(Category::getId)
                .collect(Collectors.toList()));

        return "admin/comic/editComic";
    }

    @PostMapping("/edit")
    public String editComic(@RequestParam int id, @ModelAttribute @Valid Comic comic, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "admin/comic/editComic";
        }

        comic.setId(id);   // đảm bảo id không bị thay đổi
        comicService.save(comic);
        return "redirect:/admin/comic";
    }

    // DELETE
    @GetMapping("/delete")
    public String deleteComic(@RequestParam int id) {
        comicService.delete(id);
        return "redirect:/admin/comic";
    }
}
