package com.example.springdataautomappingobject.gameshop.domain.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

public class UserRegisterDto {

    @Pattern(regexp = "\\w+@+.+", message = "Email is incorrect")
    private String email;

    @Length(min = 6, message = "Password length should be atleast 6 symbols")
    @Pattern(regexp = "[A-Z]+[a-z]+[0-9]+", message = "Password is incorrect")
    private String password;


    private String confirmPassword;
    private String fullName;

    public UserRegisterDto(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    public UserRegisterDto() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
