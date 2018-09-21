package com.codeup.investible.Services;

import com.codeup.investible.Models.Comment;
import com.codeup.investible.Repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentDao;
    private List<Comment> comments;

    public CommentService(CommentRepository commentDao){
        this.commentDao = commentDao;
    }

    public List<Comment> getComments() {
        return commentDao.findAll();
    }

    public Comment findOne(long id){
        return commentDao.findOne(id);
    }

    public Comment findOneByUser(long userId){
        return commentDao.findCommentsByUser(userId);
    }


    public Comment save(Comment comment){
        return commentDao.save(comment);
    }



}
