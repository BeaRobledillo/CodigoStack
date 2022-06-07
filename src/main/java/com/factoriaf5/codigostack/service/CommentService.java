package com.factoriaf5.codigostack.service;

import com.factoriaf5.codigostack.repository.CommentRepository;
import com.factoriaf5.codigostack.repository.PostRepository;
import com.factoriaf5.codigostack.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
}
