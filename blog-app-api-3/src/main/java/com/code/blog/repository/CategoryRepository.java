package com.code.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.blog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
