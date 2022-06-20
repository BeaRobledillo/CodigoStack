package com.factoriaf5.codigostack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Username is required")
    @Size(max = 20)
    private String username;
    @NotBlank(message = "Password is required")
    @Size(max = 150)
    private String password;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private Timestamp created;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Comment> comments;



    public User(String username,String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
