package EXAM.Exam17Dec2019.Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count(){
        return this.data.size();
    }

    public void add(Present present){
        if(this.capacity > this.data.size()){
            this.data.add(present);
        }
    }


    public  boolean remove(String name){
        for (Present present : data) {
            if(present.getName().equals(name)){
                this.data.remove(present);
                return  true;
            }
        }
        return  false;
    }


    public  Present heaviestPresent(){
        Present max = null;
        for (Present present : data) {
             if(max == null || present.getWeight() >= max.getWeight()){
                 max = present;
             }
        }
        return max;
    }

    public Present getPresent(String name){
        Present result = null;

        for (Present present : data) {
            if (present.getName().equals(name)){
                result = present;
            }
        }
        return  result;
    }

    public  String report(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s bag contains:",getColor())).append(System.lineSeparator());

        for (Present present : data) {
            output.append(present).append(System.lineSeparator());
        }

        return output.toString().trim();
    }






}
