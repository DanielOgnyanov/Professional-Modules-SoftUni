package Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    private void setMoney(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }


    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(getName() + " can't afford " + product.getName());
        }
        this.products.add(product);
        this.money -= product.getCost();

    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        String postfix = this.products.size() > 0 ?
                products.stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", "))
                : "Nothing bought";
        return this.name + " - " + postfix;
    }

}
