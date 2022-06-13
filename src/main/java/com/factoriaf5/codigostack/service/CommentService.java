package com.factoriaf5.codigostack.service;

import com.factoriaf5.codigostack.model.Comment;
import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.model.User;
import com.factoriaf5.codigostack.repository.CommentRepository;
import com.factoriaf5.codigostack.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getAll() { return  commentRepository.findAll(); }

    public Comment commentById (Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment createComment (Comment comment) { return commentRepository.save(comment); }

    public Comment delete(Long id) {commentRepository.deleteById(id); return null;}
}
