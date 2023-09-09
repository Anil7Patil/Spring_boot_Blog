package com.code.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.blog.model.Category;
import com.code.blog.payloads.CategoryDto;
import com.code.blog.repository.CategoryRepository;
import com.code.blog.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/category")

public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@PostMapping("/post")
	public ResponseEntity<CategoryDto>createCategory(@RequestBody CategoryDto categoryDto)
	{
		 CategoryDto cat=categoryServiceImpl.createCategory(categoryDto);
		 return new ResponseEntity<>(cat,HttpStatus.CREATED);
	}
	@GetMapping("/get")
	public ResponseEntity<List<CategoryDto>>grtAllCategory()
	{ 
		List<CategoryDto> cat=categoryServiceImpl.getAllCategory();
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	@GetMapping("/getById")
	public ResponseEntity<CategoryDto>getById(@RequestParam Integer categoryId)
	{
		CategoryDto cat=categoryServiceImpl.getCategoryById(categoryId);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	@DeleteMapping("delete")
	public ResponseEntity<?>deleteById(@RequestParam Integer categoryId)
	{
		categoryServiceImpl.deleteCategory(categoryId);
		return new ResponseEntity<>("Record Deleted successfully"+categoryId,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CategoryDto>updateCategory(@RequestBody CategoryDto categoryDto,@RequestParam Integer categoryId)
	{
	CategoryDto	cat=categoryServiceImpl.updateCategory(categoryDto, categoryId);
	return new ResponseEntity<>(cat,HttpStatus.CREATED);
	}
}
