package com.dt.comicWebsite.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comics")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updated_at;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
        updated_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now();
    }

    // field
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Author is mandatory")
    private String author;
    private String status;
    private String country;
    @PositiveOrZero(message = "Likes must be greater than or equal to 0.")
    private int likes = 0;

    @PositiveOrZero(message = "Views must be greater than or equal to 0.")
    private int views = 0;

    @PositiveOrZero(message = "Subscribes must be greater than or equal to 0.")
    private int subscribes = 0;

    @Column(columnDefinition = "TEXT")
    private String description;

    // relate
    @ManyToMany
    @JoinTable(
            name = "comic_category",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @NotEmpty(message = "At least one category must be selected.")
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "comic")
    private Set<Comment> comment;

    // GETTER AND SETTER
    public Integer getId() {
        return id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public String getCountry() {
        return country;
    }

    public int getLikes() {
        return likes;
    }

    public int getViews() {
        return views;
    }

    public int getSubscribes() {
        return subscribes;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setSubscribes(int subscribes) {
        this.subscribes = subscribes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }
}
