package com.dt.comicWebsite.controllers.admin;

import com.dt.comicWebsite.models.Category;
import com.dt.comicWebsite.servies.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // READ
    @GetMapping({"", "/"})
    public String showCategoryList(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "admin/category/list";
    }

    // CREATE
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category/createCategory";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    // EDIT
    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        Category category = categoryService.getById(id).get();
        model.addAttribute("category", category);
        return "admin/category/editCategory";
    }

    @PostMapping("/edit")
    public String editCategory(@RequestParam int id, @ModelAttribute Category category) {
        category.setId(id);
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    // DELETE
    @GetMapping("/delete")
    public String deleteCategory(@RequestParam int id) {
        categoryService.delete(id);
        return "redirect:/admin/category";
    }
}
