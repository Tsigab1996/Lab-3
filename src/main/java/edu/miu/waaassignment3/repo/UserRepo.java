package edu.miu.waaassignment3.repo;

import edu.miu.waaassignment3.entity.Comment;
import edu.miu.waaassignment3.entity.Post;
import edu.miu.waaassignment3.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<Users, Long> {
    List<Post> findAllById(Long id);

    @Query("SELECT users FROM Users users WHERE size( users.posts) >:n") //JPQL
    public List<Users> findAllByPostsGreaterThan(Integer n);

    @Query("SELECT u  FROM Users u join u.posts p WHERE p.title = :name")
    public List<Users> findAllByPostsByTitleEquals(String name);


    @Query("select c from Comment c join c.post p join p.users u where u.id= :a and p.id=:b and c.id =:c")

    public Comment findCommentByUserPost(Long a, Long b, Long c);



    //For Practice purpose

//    @Query("select u from Users u where size(u.posts) >:n");
//    public List<Users> getAllUser(Integer n);

 //   public  List<Users> findAllByPostsGreaterThan(Integer n);



}
