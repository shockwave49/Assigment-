package com.example.blog_app.dao;

import com.example.blog_app.bean.Post;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

public interface PostDAO  extends JpaRepository<Post, Long> {
}
