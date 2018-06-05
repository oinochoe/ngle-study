package com.ym.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ym.blog.entity.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer> {

}