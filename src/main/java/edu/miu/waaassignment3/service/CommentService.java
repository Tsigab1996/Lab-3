package edu.miu.waaassignment3.service;

import edu.miu.waaassignment3.entity.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> findAll();
    public  Comment findById(Long id);
    public void save(Comment c);
    public void delete(Long id);
}
