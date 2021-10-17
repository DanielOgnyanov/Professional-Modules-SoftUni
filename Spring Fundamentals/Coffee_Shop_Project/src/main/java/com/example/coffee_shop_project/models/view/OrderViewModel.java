package com.example.coffee_shop_project.models.view;

import com.example.coffee_shop_project.models.entities.User;

public class OrderViewModel {


    private Long id;
    private String name;
    private String price;
    private User employee;


    public OrderViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }
}
