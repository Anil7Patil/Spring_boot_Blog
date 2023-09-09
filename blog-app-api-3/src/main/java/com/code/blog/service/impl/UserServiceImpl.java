package com.code.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.blog.exception.ResourceNotFoundException;
import com.code.blog.model.User;
import com.code.blog.payloads.UserDto;
import com.code.blog.service.UserService;
import com.code.blog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelmapper;
	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepository.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer UserId) {
		
		User user=this.userRepository.findById(UserId)
				.orElseThrow(()->new ResourceNotFoundException("User","id",UserId)) ;
		
		user.setAbout(userDto.getAbout());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
	User UpdatedUser=this.userRepository.save(user);
		return this.userToUserDto(UpdatedUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User>users=this.userRepository.findAll();
		List<UserDto> userDtos=users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","id",userId)) ;
this.userRepository.delete(user);
	}
	
	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","id",userId)) ;
return this.userToUserDto(user);
	}
	
	private User dtoToUser(UserDto userDto)
	{
		User user=this.modelmapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}

	private UserDto userToUserDto(User user)
	{
		UserDto userDto=this.modelmapper.map(user, UserDto.class);
		return userDto;
	}
}
