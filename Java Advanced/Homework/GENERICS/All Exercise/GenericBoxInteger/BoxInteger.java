package Generics.GenericBoxOfInteger;

import java.util.ArrayList;
import java.util.List;

public class BoxInteger<T> {
    private List<T> values;

    public BoxInteger() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (T value : values) {
            sb.append(String.format("%s: %s", value.getClass().getName(),value));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
