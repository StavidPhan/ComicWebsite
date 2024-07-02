package com.dt.comicWebsite.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comic_category")
public class ComicCategory implements Serializable {
    @EmbeddedId
    private ComicCategoryId id;

    @ManyToOne
    @MapsId("comicId")
    @JoinColumn(name = "comic_id")
    private Comic comic;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;

    // Getters and Setters, equals(), hashCode()
}


