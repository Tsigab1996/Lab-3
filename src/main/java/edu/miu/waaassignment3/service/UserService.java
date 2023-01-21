package edu.miu.waaassignment3.service;

import edu.miu.waaassignment3.entity.Comment;
import edu.miu.waaassignment3.entity.Post;
import edu.miu.waaassignment3.entity.Users;

import java.util.List;

public interface UserService {
    public List<Users> findAll();
    public Users findById(Long id);
    public void save(Users p);
    public void delete(Long id);
    public List<Post> findAllById(Long id);

    public List<Users> findAllByPostsGreaterThan(Integer n);

    public List<Users> findAllByPostsByTitleEquals(String name);

    //public Comment findById(Long id);
    public Comment findCommentByUserPost(Long a, Long b, Long c);

}
