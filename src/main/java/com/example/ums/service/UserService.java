package com.example.ums.service;

import com.example.ums.entity.User;
import com.example.ums.exception.FindUserByIdException;
import com.example.ums.mapper.UserMapper;
import com.example.ums.repository.UserRepo;
import com.example.ums.requestdto.UserRequest;
import com.example.ums.responsedto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserService(UserRepo userRepo, UserMapper userMapper) {

        this.userRepo = userRepo;
        this.userMapper=userMapper;
    }

    public UserResponse saveUser(UserRequest userRequest) {

        User user = userRepo.save(userMapper.mapToUser(userRequest, new User()));//User is created with unique userId
        return userMapper.mapToUserResponse(user);
    }

    public UserResponse findUserById(int userId) {
       return userRepo.findById(userId)
               .map(userMapper::mapToUserResponse)
                .orElseThrow(() -> new FindUserByIdException("User not found"));
    }

    public UserResponse updateUser(UserRequest userRequest, int userId) {
        return userRepo.findById(userId)
                .map(exUser -> {
                    userMapper.mapToUser(userRequest, exUser);
                            exUser = userRepo.save(exUser);
                    return userMapper.mapToUserResponse(exUser);
                })
                .orElseThrow(()-> new FindUserByIdException("Failed to update the user"));
    }

    public UserResponse deleteUser(int userId) {
        return userRepo.findById(userId)
                .map(user -> {
                    userRepo.delete(user);
                    return userMapper.mapToUserResponse(user);
                })
                .orElseThrow(()-> new FindUserByIdException("Failed to delete"));
    }
}
