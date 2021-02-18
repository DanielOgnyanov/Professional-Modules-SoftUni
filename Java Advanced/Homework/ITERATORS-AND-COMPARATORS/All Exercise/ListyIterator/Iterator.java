package IteratorsAndComparators.ListyIterator;

import java.util.List;

public class Iterator {
    List<String> elements;
    int index;

    public Iterator (List<String> elements){
        this.elements = elements;
        if (elements.size() != 0){
            this.index = 0;
        }else {
            this.index = -1;
        }
    }

    public  boolean move(){
        if (this.index < this.elements.size()-1){
            this.index++;
            return true;
        } else {
            return false;
        }

    }

    public  String print(){
        if (this.index == -1){
            return "Invalid Operation!";
        }else {
            return this.elements.get(this.index);
        }
    }

    public  boolean hasNext(){
        return this.index < this.elements.size()-1;
    }
}
