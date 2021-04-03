package InterfacesAndAbstraction.MultipleImplementation;

public class Citizen implements Person, Identifiable , Birthable {

    private String name;
    private int age;
    private String Id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.Id = id;
        this.birthDate = birthDate;
    }
    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.Id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override

    public String toString() {
        return this.name + this.age + this.Id + this.birthDate;
    }

}

