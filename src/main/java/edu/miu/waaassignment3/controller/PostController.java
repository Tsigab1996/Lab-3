package edu.miu.waaassignment3.controller;

import edu.miu.waaassignment3.entity.Post;
import edu.miu.waaassignment3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping

    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")

    public Post findById(@PathVariable Long id){
        return  postService.findById(id);
    }

    @PostMapping

    public void save(@RequestBody  Post post){
        postService.save(post);
    }
    @GetMapping("/fitler")
    public List<Post> getMatchedPosts(@RequestParam(value = "text") String param){
        return postService.findAllByTitleEquals(param);
    }
}
