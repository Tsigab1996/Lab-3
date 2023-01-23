package edu.miu.waaassignment3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "post_id")
    @Fetch(FetchMode.SELECT )
    @JsonManagedReference
    private List<Comment> comments;

    @ManyToOne
    @JsonBackReference
    private Users users;

}
