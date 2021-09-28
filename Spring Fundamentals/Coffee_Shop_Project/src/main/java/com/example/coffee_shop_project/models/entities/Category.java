package com.example.coffee_shop_project.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private EnumCategory name;
    private EnumCategory neededTime;


    public Category() {
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
    @Enumerated(EnumType.ORDINAL)
    public EnumCategory getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(EnumCategory neededTime) {
        this.neededTime = neededTime;
    }
}
