package edu.miu.waaassignment3.controller;
import edu.miu.waaassignment3.entity.Comment;
import edu.miu.waaassignment3.entity.Post;
import edu.miu.waaassignment3.entity.Users;
import edu.miu.waaassignment3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")

public class UserController {

    private final UserService userService;
   @Autowired
    public UserController(UserService postService) {
        this.userService = postService;
    }


    @GetMapping

    public List<Users> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")

    public Users findById(@PathVariable Long id){
        return  userService.findById(id);
    }

    @PostMapping

    public void save(@RequestBody  Users users){
        userService.save(users);
    }

    @GetMapping("/posts")
    public List<Post> findAllPost(@PathVariable Long id){
        return  userService.findAllById(id);
    }

    @GetMapping("/filter")
    public List<Users> getAllUsersWithPostGreater(@RequestParam(value = "n") Integer n){
       return userService.findAllByPostsGreaterThan(n);
    }

    @GetMapping("/sameTitle")
    public List<Users> findAllByPostsByTitleEquals(@RequestParam(value = "text") String name) {
        return userService.findAllByPostsByTitleEquals(name);
    }

    @GetMapping("/{a}/posts/{b}/comments/{c}")
    public Comment getComment(@PathVariable Long a, @PathVariable Long b, @PathVariable Long c){

//        return userService.findById(a).getPosts().stream().filter(p->p.getId()==b).collect(Collectors.toList()).stream().findFirst().get().getComments()
//                .stream().filter(d->d.getId()==c).collect(Collectors.toList()).stream().findFirst().get();
        return userService.findCommentByUserPost(a,b,c);
    }


}
