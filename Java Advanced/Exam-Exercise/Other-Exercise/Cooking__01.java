package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        Map<String, Integer> food = new TreeMap<>();

        food.put("Bread", 0);
        food.put("Cake", 0);
        food.put("Pastry", 0);
        food.put("Fruit Pie", 0);


        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currLiquids = liquids.get(0);
            int currIngredients = ingredients.get(ingredients.size() - 1);

            int sum = currLiquids + currIngredients;

            switch (sum) {

                case 25:
                    food.put("Bread", food.get("Bread") + 1);
                    liquids.remove(0);
                    ingredients.remove(ingredients.size() - 1);
                    break;

                case 50:
                    food.put("Cake", food.get("Cake") + 1);
                    liquids.remove(0);
                    ingredients.remove(ingredients.size() - 1);
                    break;

                case 75:
                    food.put("Pastry", food.get("Pastry") + 1);
                    liquids.remove(0);
                    ingredients.remove(ingredients.size() - 1);
                    break;

                case 100:
                    food.put("Fruit Pie", food.get("Fruit Pie") + 1);
                    liquids.remove(0);
                    ingredients.remove(ingredients.size() - 1);
                    break;

                default:
                    liquids.remove(0);
                    ingredients.set(ingredients.size() - 1, currIngredients + 3);
                    break;
            }
        }

        if (food.get("Bread") >= 1 && food.get("Cake") >= 1 && food.get("Pastry") >= 1 && food.get("Fruit Pie") >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        if (!liquids.isEmpty()) {
            System.out.print("Liquids left: ");
            for (int i = 0; i < liquids.size(); i++) {
                if (liquids.size() - 1 == i) {
                    System.out.print(liquids.get(i));
                } else {
                    System.out.print(liquids.get(i) + ", ");
                }
            }

            System.out.println();
        } else {
            System.out.println("Liquids left: none");
        }


        if (!ingredients.isEmpty()) {
            System.out.print("Ingredients left: ");

            for (int i = ingredients.size() - 1; i >= 0; i--) {
                if (0 == i) {
                    System.out.print(ingredients.get(i));
                } else {
                    System.out.print(ingredients.get(i) + ", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Ingredients left: none");
        }


        for (Map.Entry<String, Integer> print : food.entrySet()) {
            System.out.printf("%s: %d\n", print.getKey(), print.getValue());
        }


    }
}
