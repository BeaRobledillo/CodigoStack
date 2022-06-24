package com.factoriaf5.codigostack.controller;

import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.model.User;
import com.factoriaf5.codigostack.service.PostService;
import com.factoriaf5.codigostack.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:4200/")
public class PostController {

    private final PostService postService;
    private final UserService userService;

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
        User authUser = userService.findById(1L);

        post.setUser(authUser);

        return postService.createPost(post);
    }

    @DeleteMapping("/deletepost/{id}")
    public Post deletePost(@PathVariable Long id){
        return postService.delete(id);
    }

    @PutMapping("/updatepost/")
    public Post updatePost(@RequestBody Post post) {
//        postService.findById(post.getId());

        return postService.updatePost(post);
    }


}
