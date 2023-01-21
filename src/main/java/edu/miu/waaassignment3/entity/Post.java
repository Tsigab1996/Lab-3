package edu.miu.waaassignment3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String title;
    private String content;
    private String author;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "post_id")
    @JsonManagedReference
    private List<Comment> comments;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Users users;

}
