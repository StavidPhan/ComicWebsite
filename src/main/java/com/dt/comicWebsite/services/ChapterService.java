package com.dt.comicWebsite.services;

import com.dt.comicWebsite.models.Chapter;
import com.dt.comicWebsite.models.Comic;
import com.dt.comicWebsite.repositories.ComicRepository;
import com.dt.comicWebsite.repositories.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepo;

    @Autowired
    private ComicRepository comicRepo;

    public List<Chapter> getAll() {
        return chapterRepo.findAll();
    }

    public Optional<Chapter> getById(Integer id) {
        return chapterRepo.findById(id);
    }


    public Boolean save(Chapter chapter, List<Integer> comic_ids) {
        try {
            Set<Comic> comics = new HashSet<>();
            for (Integer comic_id : comic_ids) {
                Comic comic = comicRepo.findById(comic_id).orElse(null);
                if (comic != null) {
                    comics.add(comic);
                }
                chapter.setComic(comic);
            }
            chapterRepo.save(chapter);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(Integer id) {
        try {
            chapterRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
