package com.example.xmlprocessing.domain.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends  BaseEntity{

    private String make;
    private String model;
    private int travelledDistance;
    private Set<Part> part;
    private Sale sale;

    public Car() {
    }

    @Column
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    @Column(name = "travelled_distance")
    public int getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(int travelledDistance) {
        this.travelledDistance = travelledDistance;
    }



    @ManyToMany(mappedBy = "cars",cascade = CascadeType.ALL)
    public Set<Part> getPart() {
        return part;
    }

    public void setPart(Set<Part> part) {
        this.part = part;
    }


    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
