package com.dt.comicWebsite.servies;

import com.dt.comicWebsite.models.Comic;
import com.dt.comicWebsite.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComicService {
    @Autowired
    private ComicRepository comicRepo;

    public List<Comic> getAll() {
        return comicRepo.findAll();
    }

    public Optional<Comic> getById(Integer id) {
        return comicRepo.findById(id);
    }

    public Boolean save(Comic comic) {
        try {
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
