package entities.sales;


import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")

public class Product extends BaseEntity {

    private String name;
    private double quantity;
    private BigDecimal price;

    public Product() {
    }


    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }


    @Column(name = "quantity")
    public double getQuantity() {
        return quantity;
    }


    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
