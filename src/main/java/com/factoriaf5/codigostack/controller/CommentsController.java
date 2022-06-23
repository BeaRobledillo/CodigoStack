package com.factoriaf5.codigostack.controller;


import com.factoriaf5.codigostack.model.Comment;
import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.model.User;
import com.factoriaf5.codigostack.service.CommentService;
import com.factoriaf5.codigostack.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments/")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class CommentsController {

    private final CommentService commentService;

    private final UserService userService;

    @GetMapping("/list")
    public List<Comment> commentList() {
        return commentService.getAllComments();
    }

    @PostMapping("/createcomment")
    public Comment addComment(@RequestBody Comment comment) {
        User authUser = userService.findById(1L);

        comment.setUser(authUser);

        return commentService.createComment(comment);
    }

}
