package edu.miu.waaassignment3.service.userService;

import edu.miu.waaassignment3.entity.Comment;
import edu.miu.waaassignment3.entity.Post;
import edu.miu.waaassignment3.entity.Users;
import edu.miu.waaassignment3.repo.UserRepo;
import edu.miu.waaassignment3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private UserRepo userRepo;
//
//
//    @Override
//    public List<User> findAll() {
//        return (List<User>) userRepo.findAll();
//    }
//
//    @Override
//    public User findById(Long id) {
//        return userRepo.findById(id).get();
//    }
//
//    @Override
//    public void save(User user) {
//        userRepo.save(user);
//    }
//
//    @Override
//    public void delete(Long id) {
//        userRepo.deleteById(id);
//    }
//
//    @Override
//    public List<Post> findAllById(Long id) {
//        return userRepo.findAllById(id);
//    }



    @Override
    public List<Users> findAll() {
        return  (List<Users>) userRepo.findAll();
    }

    @Override
    public Users findById(Long id) {
        return  userRepo.findById(id).get();
    }

    @Override
    public void save(Users users) {
        userRepo.save(users);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<Post> findAllById(Long id) {
        return userRepo.findAllById(id);
    }

    @Override
    public List<Users> findAllByPostsGreaterThan(Integer n) {
        return userRepo.findAllByPostsGreaterThan(n);
    }

    @Override
    public List<Users> findAllByPostsByTitleEquals(String name) {
        return userRepo.findAllByPostsByTitleEquals(name);
    }

    @Override
    public Comment findCommentByUserPost(Long a, Long b, Long c) {
        return userRepo.findCommentByUserPost(a,b,c);
    }


}
