package Polymorphism.WildFarm;

import java.text.DecimalFormat;

public abstract  class Animal {
    private String animalName;
    private String animalType;
    private double weight;
    private int foodEaten;
    private String livingReligion;
    protected Animal(String animalName, String animalType, double weight, String livingReligion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.weight = weight;
        this.livingReligion = livingReligion;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    public  abstract  void  makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override

    public String toString() {
        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.animalType,
                this.animalName,
                format.format(this.weight),
                this.livingReligion,
                this.foodEaten);
    }
}
