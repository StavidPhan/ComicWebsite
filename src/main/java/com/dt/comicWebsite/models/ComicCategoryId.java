package com.dt.comicWebsite.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ComicCategoryId implements Serializable {
    private int comicId;
    private int categoryId;

    // GETTER and SETTER, equals(), hashCode()
    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
