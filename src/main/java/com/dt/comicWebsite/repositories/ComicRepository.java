package com.dt.comicWebsite.repositories;

import com.dt.comicWebsite.models.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Integer> {
}
