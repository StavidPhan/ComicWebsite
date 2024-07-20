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
    public ComicCategoryId getId() {
        return id;
    }

    public void setId(ComicCategoryId id) {
        this.id = id;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}


