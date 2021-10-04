package com.example.coffee_shop_project.models.biding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;


    public UserLoginBindingModel() {
    }

    @Size(min = 5, max = 20 , message = "Username must be between 5 and 20 character")
    @NotBlank
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 3, message = "Password size must be atleast 3 character")
    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
