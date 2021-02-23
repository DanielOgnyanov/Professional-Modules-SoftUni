package IteratorsAndComparators.StrategyPattern;

public class People {
    String name;
    int age;
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }


}
