package com.code.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.blog.exception.ResourceNotFoundException;
import com.code.blog.model.Category;
import com.code.blog.model.User;
import com.code.blog.payloads.CategoryDto;
import com.code.blog.payloads.UserDto;
import com.code.blog.repository.CategoryRepository;

import com.code.blog.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat=this.modelmapper.map(categoryDto,Category.class);
		Category addedCat=this.categoryRepository.save(cat);
		return this.modelmapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		Category updatedCat=this.categoryRepository.save(cat);
		return this.modelmapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> cat=this.categoryRepository.findAll();
		List<CategoryDto> categoryDtos=cat.stream().map((catt)->this.modelmapper.map(catt,CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		this.categoryRepository.delete(cat);; 
		
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		return this.modelmapper.map(cat,CategoryDto.class);
	}

}
