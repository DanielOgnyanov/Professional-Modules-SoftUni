package Polymorphism.WildFarm;

public class Cat extends Felime{
    private  String breed;
    protected Cat(String animalName, String animalType, double weight, String livingReligion, String breed) {
        super(animalName, animalType, weight, livingReligion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override

    public String toString() {
        StringBuilder base = new StringBuilder(super.toString());

        base.insert(base.indexOf(",") + 1 ,  " " +this.breed + ",");

        return base.toString();
    }
}
