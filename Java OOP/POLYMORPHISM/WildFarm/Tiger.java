package Polymorphism.WildFarm;

public class Tiger extends Felime {
    protected Tiger(String animalName, String animalType, double weight, String livingReligion) {
        super(animalName, animalType, weight, livingReligion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
