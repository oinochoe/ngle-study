package com.ym.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ym.blog.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
