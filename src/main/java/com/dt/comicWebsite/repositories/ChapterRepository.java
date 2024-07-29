package com.dt.comicWebsite.repositories;

import com.dt.comicWebsite.models.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
}
