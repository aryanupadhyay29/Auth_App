package com.example.Auth_App_Backend.service;

import com.example.Auth_App_Backend.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByEmail(String email);

    UserDto updateUser(UserDto userDto , String userId);

    void deleteUser(String userId);
    UserDto getUserById(String userId);

    Iterable<UserDto> getAllUsers();
}
