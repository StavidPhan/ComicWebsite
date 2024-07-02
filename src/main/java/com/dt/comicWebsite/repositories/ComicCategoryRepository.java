package com.dt.comicWebsite.repositories;

import com.dt.comicWebsite.models.ComicCategory;
import com.dt.comicWebsite.models.ComicCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicCategoryRepository extends JpaRepository<ComicCategory, ComicCategoryId> {
}