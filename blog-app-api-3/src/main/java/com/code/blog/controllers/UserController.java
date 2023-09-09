package com.code.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.blog.payloads.UserDto;
import com.code.blog.service.UserService;



@RestController
@RequestMapping("/api")

public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/postUser")
	public ResponseEntity<UserDto>createUser( @RequestBody @Valid UserDto userDto)
	{
	UserDto createUserDto=	this.userService.createUser(userDto);
	return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}

	@GetMapping("/getUser")
	public ResponseEntity<List<UserDto>>getAllUsers()
	{
	List<UserDto> createUserDto=this.userService.getAllUsers();
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteUser")
	 ResponseEntity <String>deleteUser(@RequestParam Integer userId)
	{
		this.userService.deleteUser(userId);
		return new ResponseEntity<>("Record Deleted succesfullay",HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	ResponseEntity<UserDto>updateUser( @RequestBody @Valid UserDto userDto,@RequestParam Integer UserId)
	{
		UserDto updatedUser=this.userService.updateUser(userDto, UserId);
		return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
	}
	@GetMapping("/getById")
	ResponseEntity<UserDto>getUserById(@RequestParam Integer userId)
	{
		UserDto user=userService.getUserById(userId);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	@GetMapping("/getById")
	ResponseEntity<UserDto>getUsderById(@RequestParam Integer userId)
	{
		UserDto user=userService.getUserById(userId);
		return new ResponseEntity<UserDto>(user,HttpStatus.CHECKPOINT;
	}
	
}
