package com.ym.blog.infrastructure.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ym.blog.entity.Post;


public interface PostDao extends JpaRepository<Post, Integer> {

	Page<Post> findByCategoryId(int categoryId, Pageable pageable);
}