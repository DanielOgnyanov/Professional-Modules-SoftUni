package Inheritance.Person;

public class Person {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected String name;
    protected int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}
