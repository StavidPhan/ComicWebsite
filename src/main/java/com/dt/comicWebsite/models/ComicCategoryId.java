package com.dt.comicWebsite.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicCategoryId that = (ComicCategoryId) o;
        return comicId == that.comicId &&
                categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comicId, categoryId);
    }
}
