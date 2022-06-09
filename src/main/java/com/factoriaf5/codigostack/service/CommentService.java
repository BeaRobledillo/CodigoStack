package com.factoriaf5.codigostack.service;

import com.factoriaf5.codigostack.model.Comment;
import com.factoriaf5.codigostack.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CommentService {
    private final CommentRepository CommentRepository;

    public List<Comment> getAllComments() {return CommentRepository.findAll();};
}
