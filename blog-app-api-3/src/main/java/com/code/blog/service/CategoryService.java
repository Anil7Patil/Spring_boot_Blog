package com.code.blog.service;

import java.util.List;

import com.code.blog.payloads.CategoryDto;
import com.code.blog.payloads.UserDto;

public interface CategoryService {
	
	CategoryDto	createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	List<CategoryDto> getAllCategory();
	void deleteCategory(Integer categoryId);
	CategoryDto getCategoryById(Integer categoryId);

}
