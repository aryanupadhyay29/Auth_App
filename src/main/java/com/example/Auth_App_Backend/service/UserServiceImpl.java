package com.example.Auth_App_Backend.service;

import com.example.Auth_App_Backend.dto.UserDto;
import com.example.Auth_App_Backend.entity.Provider;
import com.example.Auth_App_Backend.entity.Users;
import com.example.Auth_App_Backend.exception.ResourceNotFoundException;
import com.example.Auth_App_Backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        if(userDto.getEmail() == null || userDto.getEmail().isBlank()) throw new IllegalArgumentException("Email is required");
        if(userRepository.existsByEmail(userDto.getEmail())) throw new IllegalArgumentException("Email already exists");
        Users user = modelMapper.map(userDto , Users.class);
        user.setProvider(userDto.getProvider() == null ? Provider.LOCAL : userDto.getProvider());
        //role assign here to user .. for authorization
        Users savedUser = userRepository.save(user);
        return modelMapper.map(savedUser , UserDto.class) ;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        Users user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given Email Id"));
        return user == null ? null : modelMapper.map(user , UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public UserDto getUserById(String userId) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<UserDto> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map( user -> modelMapper.map(user , UserDto.class))
                .toList();
    }
}
