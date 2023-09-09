package com.code.blog.service;
import java.util.List;

import com.code.blog.payloads.UserDto;
public interface UserService {

UserDto	createUser(UserDto user);
UserDto updateUser(UserDto user,Integer UserId);
List<UserDto> getAllUsers();
void deleteUser(Integer userId);
UserDto getUserById(Integer userId);
}
