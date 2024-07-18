package com.dt.comicWebsite.servies;

import com.dt.comicWebsite.models.Category;
import com.dt.comicWebsite.models.Comic;
import com.dt.comicWebsite.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public Optional<Category> getById(Integer id) {
        return categoryRepo.findById(id);
    }

    public Boolean save(Category category) {
        try {
            categoryRepo.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(Integer id) {
        try {
            categoryRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
