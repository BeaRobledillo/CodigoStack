package com.factoriaf5.codigostack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serial;

import java.time.Instant;
import java.util.Collection;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User   {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Email
    private String email;
    private Instant created;
    private boolean enabled;
    @OneToMany(mappedBy = "user")
    private Collection<Comment> comment;

    @OneToMany(mappedBy = "user")
    private Collection<Post> post;

    public Collection<Post> getPost() {
        return post;
    }

    public void setPost(Collection<Post> post) {
        this.post = post;
    }
}
