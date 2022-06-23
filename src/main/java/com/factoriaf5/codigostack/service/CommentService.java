package com.factoriaf5.codigostack.service;

import com.factoriaf5.codigostack.model.Comment;
import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return  commentRepository.findAll();
    }

    public Comment createComment(Comment comment) { return commentRepository.save(comment);}

}
