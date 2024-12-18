package com.example.blog_app.controller;

import com.example.blog_app.bean.Post;
import com.example.blog_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        model.addAttribute("post", new Post()); // For the create/update form
        return "index"; // Renders the index.html
    }

    @PostMapping("/createPost")
    public String createPost(Post post) {
        postService.createPost(post);
        return "redirect:/"; // Again to getAllpost page
    }

    @PostMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        return "redirect:/";
    }

    @GetMapping("/updatePost/{id}")
    public String updatePost(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        model.addAttribute("post", post); // Prefills the form for editing
        return "index";
    }
}
