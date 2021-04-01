package Inheritance.Restaurant;

import java.math.BigDecimal;

public class Product {
    protected String name;
    protected BigDecimal price = BigDecimal.valueOf(0.0);

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }



}
