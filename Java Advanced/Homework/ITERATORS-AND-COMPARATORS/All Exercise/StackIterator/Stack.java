package IteratorsAndComparators.StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Stack {
    public Stack(ArrayDeque<String> elements) {
        this.elements = elements;
    }

    ArrayDeque<String> elements;
    String elementToPush;


    public void pop() {
        if (!elements.isEmpty()) {
            elements.pop();
        } else {
            System.out.println("No elements");
        }
    }

    public void push() {
        elements.push(elementToPush);
    }

    public void toPrint() {
        Iterator<String> iterator = elements.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
