package com.solvd.qa.carina.demo.db.mappers;

import com.solvd.qa.carina.demo.db.models.Comment;

public interface CommentMapper {
    void create(Comment comment);

    // TODO: maybe add a getByCommentId method

    Comment findById(long id);

    Comment findByCommentName(String commentName);

    void update(Comment comment);

    void delete(Comment comment);
}
