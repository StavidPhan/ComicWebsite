package com.dt.comicWebsite.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updated_at;

    @Column(columnDefinition = "TEXT")
    private String content;

    // RELATE
    @ManyToOne
    @JoinColumn(name = "comic_id")
    private Comic comic;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // GETTER, SETTER

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
