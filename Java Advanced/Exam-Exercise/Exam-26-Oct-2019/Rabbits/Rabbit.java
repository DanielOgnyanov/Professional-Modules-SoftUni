package EXAM.Exam26Oct2019.Rabbits;

public class Rabbit {

    private String name;
    private String species;
    private boolean available = true;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }


    @Override
    public String toString() {
        return String.format("Rabbit (%s): %s", getSpecies(), getName());
    }


}
