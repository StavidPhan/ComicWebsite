package com.dt.comicWebsite.services;

import com.dt.comicWebsite.models.Comic;
import com.dt.comicWebsite.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComicService {
    @Autowired
    private ComicRepository comicRepo;

    public List<Comic> getAll() {
        return comicRepo.findAll();
    }

    public Comic getById(Integer id) {
        return comicRepo.findById(id).orElseThrow(() -> new RuntimeException("Comic not found!"));
    }

    @Transactional
    public Boolean save(Comic comic) {
        try {
            // creat a new Comic
            if (comic.getId() == null) {
                comicRepo.save(comic);
            } else {
                // update Comic
                Comic existingComic = comicRepo.findById(comic.getId()).orElseThrow(() -> new RuntimeException("Comic not found in edit Comic"));
                existingComic.setName(comic.getName());
                existingComic.setAuthor(comic.getAuthor());
                existingComic.setStatus(comic.getStatus());
                existingComic.setCountry(comic.getCountry());
                existingComic.setLikes(comic.getLikes());
                existingComic.setViews(comic.getViews());
                existingComic.setSubscribes(comic.getSubscribes());
                existingComic.setDescription(comic.getDescription());
                existingComic.setCategories(comic.getCategories());
                comicRepo.save(existingComic);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void delete(Integer id) {
        try {
            comicRepo.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
