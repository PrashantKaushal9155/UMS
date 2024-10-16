package com.example.ums.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
    @NotNull(message = "Username Can't be null")
    @NotBlank(message = "Username can't be blank")
    @Pattern(regexp = "^[A-Z][a-z0-9_]{2,39}$", message = "UserName starts with uppercase and length must be 3-40 characters long")
    private String username;
    @Pattern(regexp = "^[a-zA-Z0-9]+@gmail.com$", message = "Email should end with @gmail.com")
    private String email;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=.{8,15})$", message = "Password length should be 8-15 characters" +
            "One UpperCase character and one Special character is mandatory")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
