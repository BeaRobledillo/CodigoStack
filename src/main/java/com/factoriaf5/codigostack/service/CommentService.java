package com.factoriaf5.codigostack.service;

import com.factoriaf5.codigostack.model.Comment;
import com.factoriaf5.codigostack.repository.CommentRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor

public class CommentService {
    private final CommentRepository CommentRepository;

    public List<Comment> getAllComments() {return CommentRepository.findAll();}

    public Comment findById (Long id) {
        return CommentRepository.findById(id).orElse(null);
    }

    public Comment createComment (Comment comment) { return CommentRepository.save(comment); }

    public Comment delete(Long id) {CommentRepository.deleteById(id); return null;}

}
