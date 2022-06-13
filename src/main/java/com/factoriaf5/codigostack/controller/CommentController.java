package com.factoriaf5.codigostack.controller;

import com.factoriaf5.codigostack.model.Comment;
import com.factoriaf5.codigostack.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
public class CommentController {

    private final CommentService CommentService;

    //
    @GetMapping("/list")
    // acceso tipo nombre (parametros) {}
    public List<Comment> CommentList() {
        return CommentService.getAllComments();
    }
}
