package EXAM.Exam19August2020.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet result = null;
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                result = pet;
            }
        }
        return result;
    }

    public Pet getOldestPet() {
        Pet result = null;
        for (Pet pet : data) {
            if (result == null || result.getAge() <= pet.getAge()) {
                result = pet;
            }
        }
        return result;
    }

    public int getCount() {
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append("The clinic has the following patients:").append(System.lineSeparator());

        for (Pet pet : data) {
            output.append(pet.getName())
                    .append(" ")
                    .append(pet.getOwner())
                    .append(System.lineSeparator());
        }

        return output.toString().trim();
    }

}
