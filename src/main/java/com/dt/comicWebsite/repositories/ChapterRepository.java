package com.dt.comicWebsite.repositories;

import com.dt.comicWebsite.models.Chapter;
import com.dt.comicWebsite.models.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    Chapter findByComicAndChapterNumber(Comic comic, int chapterNumber);
}
