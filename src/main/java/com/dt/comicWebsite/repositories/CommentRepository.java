package com.dt.comicWebsite.repositories;

import com.dt.comicWebsite.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Integer> {
}
