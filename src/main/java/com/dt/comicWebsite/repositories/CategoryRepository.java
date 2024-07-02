package com.dt.comicWebsite.repositories;

import com.dt.comicWebsite.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
