package EXAM.Exam17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> material = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> levelMagic = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));
        int doll = 0;
        int train = 0;
        int bear = 0;
        int bicycle = 0;

        while (material.size() > 0 && levelMagic.size() > 0) {
            int currMaterial = material.get(material.size() - 1);
            int currLevel = levelMagic.get(0);
            int calcValue = material.get(material.size() - 1) * levelMagic.get(0);

            if (calcValue < 0) {
                int numToAdded = currMaterial + currLevel;
                material.remove(material.size() - 1);
                levelMagic.remove(0);
                material.add(numToAdded);
            }

            if (currMaterial == 0 || currLevel == 0) {
                if (currMaterial == 0) {
                    material.remove(material.size() - 1);
                }
                if (currLevel == 0) {
                    levelMagic.remove(0);
                }
            }

            switch (calcValue) {
                case 150:
                    material.remove(material.size() - 1);
                    levelMagic.remove(0);
                    doll++;
                    break;
                case 250:
                    material.remove(material.size() - 1);
                    levelMagic.remove(0);
                    train++;
                    break;
                case 300:
                    material.remove(material.size() - 1);
                    levelMagic.remove(0);
                    bear++;
                    break;
                case 400:
                    material.remove(material.size() - 1);
                    levelMagic.remove(0);
                    bicycle++;
                    break;
            }

            if (calcValue > 0 && calcValue != 150 && calcValue != 250 && calcValue != 300 && calcValue != 400) {
                levelMagic.remove(0);
                material.set(material.size() - 1, material.get(material.size() - 1) + 15);
            }


        }

        Map<String, Integer> toPrint = new TreeMap<>();
        if (doll > 0) {
            toPrint.put("Doll", doll);
        }
        if (train > 0) {
            toPrint.put("Wooden train", train);
        }
        if (bicycle > 0) {
            toPrint.put("Bicycle", bicycle);
        }
        if (bear > 0) {
            toPrint.put("Teddy bear", bear);
        }

        if (doll >= 1 && train >= 1) {
            System.out.println("The presents are crafted! Merry EXAM.Exam17Dec2019.Christmas!");
            printLeftMaterial(material);

            printLeftMagic(levelMagic);

            for (Map.Entry<String, Integer> gift : toPrint.entrySet()) {
                System.out.printf("%s: %d\n", gift.getKey(), gift.getValue());
            }
        } else if (bear >= 1 && bicycle >= 1) {
            System.out.println("The presents are crafted! Merry EXAM.Exam17Dec2019.Christmas!");
            printLeftMaterial(material);

            printLeftMagic(levelMagic);

            for (Map.Entry<String, Integer> gift : toPrint.entrySet()) {
                System.out.printf("%s: %d\n", gift.getKey(), gift.getValue());
            }

        } else {
            System.out.println("No presents this EXAM.Exam17Dec2019.Christmas!");
            printLeftMaterial(material);

            printLeftMagic(levelMagic);

            for (Map.Entry<String, Integer> gift : toPrint.entrySet()) {
                if (gift.getValue() > 0) {
                    System.out.printf("%s: %d\n", gift.getKey(), gift.getValue());
                }

            }

        }
    }

    private static void printLeftMagic(List<Integer> levelMagic) {
        if (!levelMagic.isEmpty()) {
            System.out.print("Magic left: ");

            for (int i = 0; i < levelMagic.size(); i++) {
                if (levelMagic.size() - 1 == i) {
                    System.out.print(levelMagic.get(i));
                    System.out.println();
                } else {
                    System.out.print(levelMagic.get(i) + ", ");
                }

            }
        }
    }

    private static void printLeftMaterial(List<Integer> material) {
        if (!material.isEmpty()) {
            System.out.print("Materials left: ");

            for (int i = material.size() - 1; i >= 0; i--) {
                if (0 == i) {
                    System.out.print(material.get(i));
                    System.out.println();
                } else {
                    System.out.print(material.get(i) + ", ");
                }

            }
        }
    }
}
