package Generics.GenericSwapMethodInteger;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        SwapInteger<Integer> elements = new SwapInteger<>();
        for (int i = 0; i < count; i++) {
            int currElements = Integer.parseInt(scanner.nextLine());
            elements.add(currElements);
        }
        String numAsString = scanner.nextLine();
        String[] indexArray = numAsString.split("\\s+");
        int firstIndex = Integer.parseInt(indexArray[0]);
        int secondIndex = Integer.parseInt(indexArray[1]);

        elements.setElements(elements.elements, firstIndex, secondIndex);


        System.out.println(elements);
    }
}
