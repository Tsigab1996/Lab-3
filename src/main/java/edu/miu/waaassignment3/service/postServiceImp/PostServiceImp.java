package edu.miu.waaassignment3.service.postServiceImp;

import edu.miu.waaassignment3.entity.Post;
import edu.miu.waaassignment3.repo.PostRepo;
import edu.miu.waaassignment3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImp implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepo.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepo.findById(id).get();
    }


    @Override
    public void save(Post p) {
    postRepo.save(p);
    }

    @Override
    public void delete(Long id) {
      postRepo.deleteById(id);
    }

    @Override
    public List<Post> findAllByTitleEquals(String param) {
        return postRepo.findAllByTitleEquals(param);
    }
}
