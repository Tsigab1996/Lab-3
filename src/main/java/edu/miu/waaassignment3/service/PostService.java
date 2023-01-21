package edu.miu.waaassignment3.service;

import edu.miu.waaassignment3.entity.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
    public  Post findById(Long id);
    public void save(Post p);
    public void delete(Long id);
    public List<Post> findAllByTitleEquals(String param);
}
