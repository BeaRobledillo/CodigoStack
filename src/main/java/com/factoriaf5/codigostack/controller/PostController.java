package com.factoriaf5.codigostack.controller;

import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    //
    @GetMapping("/list")
    // acceso tipo nombre (parametros) {}
    public List<Post> postList() {
        return postService.getAllPosts();
    }
}
