package com.dt.comicWebsite.repositories;

import com.dt.comicWebsite.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
