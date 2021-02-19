package IteratorsAndComparators.Collection;

import java.util.List;

public class Collection {
    List<String> elements;
    int index;

    public Collection(List<String> elements) {
        this.elements = elements;
        if (elements.size() != 0) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    public boolean move() {
        if (this.index < this.elements.size() - 1) {
            this.index++;
            return true;
        } else {
            return false;
        }

    }

    public String print() {
        if (this.index == -1) {
            return "Invalid Operation!";
        } else {
            return this.elements.get(this.index);
        }
    }

    public boolean hasNext() {
        return this.index < this.elements.size() - 1;
    }

    public void printAll() {
        for (String element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
