package com.factoriaf5.codigostack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    private Timestamp created;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Comment> comments;

    public User(String username, String password, String email, Timestamp created, boolean b, Set<Post> posts, Set<Comment> comments) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.created = created;
        this.posts = posts;
        this.comments = comments;
    }
}
