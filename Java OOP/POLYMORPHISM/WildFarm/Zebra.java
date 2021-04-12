package Polymorphism.WildFarm;

public class Zebra extends  Mammal {
    protected Zebra(String animalName, String animalType, double weight, String livingReligion) {
        super(animalName, animalType, weight, livingReligion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof  Meat){
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
