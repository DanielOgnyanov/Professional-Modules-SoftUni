package IteratorsAndComparators.ListyIterator;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toCollection(ArrayList::new));
        Iterator iterator = new Iterator(elements);
       String command = scanner.nextLine();

       while (!command.equals("END")){

           switch (command){

               case "Move":
                   System.out.println(iterator.move());
                   break;
               case "Print":
                   System.out.println(iterator.print());
                   break;
               case "HasNext":
                   System.out.println(iterator.hasNext());
                   break;
           }


           command = scanner.nextLine();
       }
    }
}
