package com.factoriaf5.codigostack.repository;

import com.factoriaf5.codigostack.model.Comment;
import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
    List<Comment> findAllByUser(User user);
}
