package com.factoriaf5.codigostack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String text;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id", nullable=false)
    @JsonIgnore
    private Post post;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable=false)
    private User user;
}
