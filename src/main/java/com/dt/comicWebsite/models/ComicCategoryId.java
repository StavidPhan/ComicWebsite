package com.dt.comicWebsite.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ComicCategoryId implements Serializable {
    private int comicId;
    private int categoryId;

    // Getters and Setters, equals(), hashCode()
}
