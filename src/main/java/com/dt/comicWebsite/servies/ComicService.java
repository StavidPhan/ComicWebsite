package com.dt.comicWebsite.servies;

import com.dt.comicWebsite.models.Category;
import com.dt.comicWebsite.models.Comic;
import com.dt.comicWebsite.repositories.CategoryRepository;
import com.dt.comicWebsite.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ComicService {
    @Autowired
    private ComicRepository comicRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    public List<Comic> getAll() {
        return comicRepo.findAll();
    }

    public Optional<Comic> getById(Integer id) {
        return comicRepo.findById(id);
    }


    public Boolean save(Comic comic, List<Integer> categoryIds) {
        try {
            Set<Category> categories = new HashSet<>();
            for (Integer categoryId : categoryIds) {
                Category category = categoryRepo.findById(categoryId).orElse(null);
                if (category != null) {
                    categories.add(category);
                }
            }
            comic.setCategories(categories);
            comicRepo.save(comic);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(Integer id) {
        try {
            comicRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
