package com.example.ums.mapper;

import com.example.ums.entity.User;
import com.example.ums.requestdto.UserRequest;
import com.example.ums.responsedto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserRequest userRequest, User user) {
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        return user;
    }

    public UserResponse mapToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());

        return response;
    }
}
