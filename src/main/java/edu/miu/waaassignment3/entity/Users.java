package edu.miu.waaassignment3.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Component
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name="users_id")
    @JsonManagedReference
    private List<Post> posts;
        }
