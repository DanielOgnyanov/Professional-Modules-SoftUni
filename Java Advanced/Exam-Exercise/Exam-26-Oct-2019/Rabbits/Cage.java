package EXAM.Exam26Oct2019.Rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Rabbit rabbit) {
        if (this.capacity > this.data.size()) {
            this.data.add(rabbit);
        }
    }


    public boolean removeRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                this.data.remove(rabbit);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                this.data.remove(rabbit);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit result = null;

        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                result = rabbit;
            }
        }
        return result;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> result = new ArrayList<>();

        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                result.add(rabbit);
            }
        }

        for (Rabbit rabbit : result) {
            this.data.remove(rabbit);
        }
        return result;
    }


    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("EXAM.Exam26Oct2019.Rabbits available at %s:", name)).append(System.lineSeparator());

        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()) {
                output.append(rabbit).append(System.lineSeparator());
            }
        }

        return output.toString().trim();
    }

}
