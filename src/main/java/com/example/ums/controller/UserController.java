package com.example.ums.controller;

import com.example.ums.entity.User;
import com.example.ums.requestdto.UserRequest;
import com.example.ums.responsedto.UserResponse;
import com.example.ums.service.UserService;
import com.example.ums.util.AppResponseBuilder;
import com.example.ums.util.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final AppResponseBuilder responseBuilder;

    public UserController(UserService userService, AppResponseBuilder responseBuilder) {
        this.userService = userService;
        this.responseBuilder=responseBuilder;
    }

    @GetMapping("/users")
    public User findUser(){
        User user = new User();
        user.setUserId(1);
        user.setEmail("abc@gmail.com");
        user.setUsername("abc");
        user.setPassword("1234");

        return user;
    }
//    @PostMapping("/save-user")
//    public User saveUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }

    @PostMapping("/save-user")
    public ResponseEntity<ResponseStructure<UserResponse>> saveUser(@RequestBody @Valid UserRequest userRequest) {
        UserResponse userResponse = userService.saveUser(userRequest);
        return responseBuilder.success(HttpStatus.CREATED, "User Created", userResponse);
    }

    @GetMapping("/find-user")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@RequestParam("user_id") int userId){
        UserResponse response = userService.findUserById(userId);
    return responseBuilder.success(HttpStatus.FOUND, "User Found", response);
    }

    @PutMapping("/update-user")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest, @RequestParam("user_id") int userId){
        UserResponse response = userService.updateUser(userRequest, userId);
        return responseBuilder.success(HttpStatus.OK,"User Updated", response);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<ResponseStructure<UserResponse>> deleteUser(@RequestParam("user_id") int userId){
        UserResponse response = userService.deleteUser(userId);
        return responseBuilder.success(HttpStatus.OK,"User deleted", response);
    }
}
