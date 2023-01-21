package edu.miu.waaassignment3.repo;

import edu.miu.waaassignment3.entity.Post;
import edu.miu.waaassignment3.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    //@Query("SELECT P FROM Post p WHERE p.title = :param");
    public List<Post> findAllByTitleEquals(String param);


}
