package com.dt.comicWebsite.controllers.admin;

import com.dt.comicWebsite.models.Chapter;
import com.dt.comicWebsite.services.ChapterService;
import com.dt.comicWebsite.services.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @Autowired
    private ComicService comicService;

    // READ
    @GetMapping({"", "/"})
    public String showChapterList(Model model) {
        List<Chapter> chapters = chapterService.getAll();
        model.addAttribute("chapters", chapters);
        return "admin/chapter/list";
    }

    // CREATE
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("chapter", new Chapter());
        model.addAttribute("comics", comicService.getAll());
        return "admin/chapter/create";
    }

    @PostMapping("/create")
    public String createChapter(@ModelAttribute Chapter chapter, @RequestParam List<Integer> comic_id) {
        chapterService.save(chapter, comic_id);
        return "redirect:/admin/chapter";
    }

    // EDIT
    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        Chapter chapter = chapterService.getById(id).get();
        model.addAttribute("chapter", chapter);
        model.addAttribute("comics", comicService.getAll());
        return "admin/chapter/edit";
    }

    @PostMapping("/edit")
    public String editChapter(@RequestParam int id, @ModelAttribute Chapter chapter, @RequestParam List<Integer> comic_id) {
        chapter.setId(id);   // đảm bảo id không bị thay đổi
        chapterService.save(chapter, comic_id);
        return "redirect:/admin/chapter";
    }

    // DELETE
    @GetMapping("/delete")
    public String deleteChapter(@RequestParam int id) {
        chapterService.delete(id);
        return "redirect:/admin/chapter";
    }
}
