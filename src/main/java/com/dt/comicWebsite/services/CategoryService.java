package com.dt.comicWebsite.services;

import com.dt.comicWebsite.models.Category;
import com.dt.comicWebsite.repositories.CategoryRepository;
import com.dt.comicWebsite.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ComicRepository comicRepo;

    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public Optional<Category> getById(Integer id) {
        return categoryRepo.findById(id);
    }

    public void save(Category category) {
        try {
            categoryRepo.save(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasComics(int categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found."));
        return !category.getComics().isEmpty();
    }

    public void delete(int id) {
        try {
            categoryRepo.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }
}
