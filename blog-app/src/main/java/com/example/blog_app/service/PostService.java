package com.example.blog_app.service;

import com.example.blog_app.bean.Post;
import com.example.blog_app.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDAO postDAO;

    // Create a post and save it to the database
    public Post createPost(Post post) {
        return postDAO.save(post);
    }

    public Post getPostById(Long id) {
        return postDAO.findById(id).orElseThrow(() -> new RuntimeException(id + " -> This id doesn't exists"));
    }

    public List<Post> getAllPost() {
        return postDAO.findAll();
    }

    public void updatePostById(Post post, Long id){
        if(postDAO.findById(id).isPresent()) {
            Post newPost = new Post();
            newPost.setId(id);
            newPost.setTitle(post.getTitle());
            newPost.setDescription(post.getDescription());

            postDAO.save(newPost);
        } else {
            throw new RuntimeException(id + " -> This id doesn't exists");
        }
    }


    public void deletePostById(Long id) {
        if(postDAO.findById(id).isPresent()) {
            postDAO.deleteById(id);
        } else {
            throw new RuntimeException(id + " -> This id doesn't exists");
        }
    }
}
