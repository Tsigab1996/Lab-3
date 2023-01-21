package edu.miu.waaassignment3.service.commentServiceImp;

import edu.miu.waaassignment3.entity.Comment;
import edu.miu.waaassignment3.repo.CommentRepo;
import edu.miu.waaassignment3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Override
    public List<Comment> findAll() {
        return (List<Comment>) commentRepo.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepo.findById(id).get();
    }


    @Override
    public void save(Comment c) {
     commentRepo.save(c);
    }

    @Override
    public void delete(Long id) {
     commentRepo.deleteById(id);
    }
}
