package com.dt.comicWebsite.controllers.admin;

import com.dt.comicWebsite.models.Category;
import com.dt.comicWebsite.servies.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "admin/category/listCategory";
    }

    // CREATE
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category/createCategory";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute @Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/category/createCategory";
        }

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
    public String editCategory(@RequestParam int id, @Valid @ModelAttribute Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/category/editCategory";
        }

        category.setId(id);
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    // DELETE
    @GetMapping("/delete")
    public String deleteCategory(@RequestParam int id, RedirectAttributes redirectAttributes) {
        if (categoryService.hasComics(id)) {
            redirectAttributes.addFlashAttribute("error", "Category cannot be deleted because it is associated with existing comics.");
            return "redirect:/admin/category";
        }

        categoryService.delete(id);
        return "redirect:/admin/category";
    }
}
