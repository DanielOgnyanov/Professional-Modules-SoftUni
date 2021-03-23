package Encapsulation.AnimalFarm;

public class Chicken {
    private String name;
    private int age;


    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if(name.length() > 1) {
            this.name = name;
        } else {
            throw  new IllegalArgumentException("Name cannot be empty.");
        }
    }


    private void setAge(int age) {
        if(age > 0 && age <= 15) {
            this.age = age;
        } else {
            throw  new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    private double calculateProductPerDay() {
        double result = 0;

        if (age >= 0 && age <= 5) {
            result = 2;
        } else if (age > 5 && age <= 11) {
            result = 1;
        } else if (age > 11 && age < 15) {
            result = 0.75;
        }

        return result;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override

    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age,productPerDay());
    }
}
