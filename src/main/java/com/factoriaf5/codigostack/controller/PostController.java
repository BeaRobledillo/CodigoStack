package com.factoriaf5.codigostack.controller;

import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list/{id}")
    public Post findPostById(@PathVariable Long id) {
        return postService.postById(id);
    }

    @PostMapping("/createpost")
    public Post addPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @DeleteMapping("/deletepost/{id}")
    public Post deletePost(@PathVariable Long id){
        return postService.delete(id);
    }

    @PutMapping("/updatepost/{id}")
    public Post updatePost(@RequestBody Post post) {
        postService.postById(post.getId());
        return postService.createPost(post);
    }

}
