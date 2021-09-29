package com.example.coffee_shop_project.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private EnumCategory name;
    private int neededTime;


    public Category() {
    }

    public Category(EnumCategory name, int time) {
        this.name = name;
        this.neededTime = time;
    }


    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public EnumCategory getName() {
        return name;
    }

    public void setName(EnumCategory name) {
        this.name = name;
    }

    @Column(name = "needed_time")
    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }
}
