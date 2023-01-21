package edu.miu.waaassignment3.controller;

import edu.miu.waaassignment3.entity.Comment;
import edu.miu.waaassignment3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping

    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")

    public Comment findById(@PathVariable Long id){
        return  commentService.findById(id);
    }

    @PostMapping

    public void save(@RequestBody Comment comment){
        commentService.save(comment);
    }



}
