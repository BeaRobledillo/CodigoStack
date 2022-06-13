package com.factoriaf5.codigostack.service;

import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.repository.PostRepository;

import com.factoriaf5.codigostack.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return  postRepository.findAll();
    }

    public Post findById (Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost (Post post) { return postRepository.save(post);  
         
    public Post updatePost (Post post) {
        Post oldPost = postRepository.findById(post.getId()).orElseThrow(()->
        new RuntimeException("Post not found"));
        oldPost.setPostName(post.getPostName());
        oldPost.setDescription(post.getDescription());
        oldPost.setUrl(post.getUrl());
        oldPost.setVoteCount(post.getVoteCount());

        return postRepository.save(oldPost);
    }

    public Post delete(Long id) {postRepository.deleteById(id); return null;}







    /*
        1. crear un post **
        2. buscar un post por id **
        3. borrar un post **
        4. modificar un post **
     */

}