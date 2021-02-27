package EXAM.Exam28June2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> bombEffect = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> casingEffect = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));

        int datura = 0;
        int cherry = 0;
        int decoy = 0;
        boolean stop = false;
        for (int i = 0; i < bombEffect.size(); i++) {
            int currBomb = bombEffect.get(i);

            for (int j = casingEffect.size() - 1; j >= 0; j--) {
                int currCasing = casingEffect.get(j);

                if (bombEffect.get(i) + casingEffect.get(j) == 40) {
                    datura++;
                    bombEffect.remove(i);
                    casingEffect.remove(j);
                    i--;
                    if (datura >= 3 && cherry >= 3 && decoy >= 3) {

                        System.out.println("Bene! You have successfully filled the bomb pouch!");

                        if (!bombEffect.isEmpty()) {
                            System.out.print("EXAM.Bomb Effects: ");
                            for (int k = 0; k < bombEffect.size(); k++) {
                                if (bombEffect.size() - 1 == k) {
                                    System.out.print(bombEffect.get(k));
                                    System.out.println();
                                } else {
                                    System.out.print(bombEffect.get(k) + ", ");
                                }
                            }
                        } else {
                            System.out.println("EXAM.Bomb Effects: empty");
                        }

                        if (!casingEffect.isEmpty()) {
                            System.out.print("EXAM.Bomb Casings: ");
                            for (int k = 0; k < casingEffect.size(); k++) {
                                if (casingEffect.size() - 1 == k) {
                                    System.out.print(casingEffect.get(k));
                                    System.out.println();
                                } else {
                                    System.out.print(casingEffect.get(k) + ", ");
                                }
                            }
                        } else {
                            System.out.println("EXAM.Bomb Casings: empty");
                        }

                        System.out.printf("Cherry Bombs: %d\n", cherry);
                        System.out.printf("Datura Bombs: %d\n", datura);
                        System.out.printf("Smoke Decoy Bombs: %d", decoy);
                        return;
                    }

                    break;
                } else if (bombEffect.get(i) + casingEffect.get(j) == 60) {
                    cherry++;
                    bombEffect.remove(i);
                    casingEffect.remove(j);
                    i--;
                    if (datura >= 3 && cherry >= 3 && decoy >= 3) {

                        System.out.println("Bene! You have successfully filled the bomb pouch!");

                        if (!bombEffect.isEmpty()) {
                            System.out.print("EXAM.Bomb Effects: ");
                            for (int k = 0; k < bombEffect.size(); k++) {
                                if (bombEffect.size() - 1 == k) {
                                    System.out.print(bombEffect.get(k));
                                    System.out.println();
                                } else {
                                    System.out.print(bombEffect.get(k) + ", ");
                                }
                            }
                        } else {
                            System.out.println("EXAM.Bomb Effects: empty");
                        }

                        if (!casingEffect.isEmpty()) {
                            System.out.print("EXAM.Bomb Casings: ");
                            for (int k = 0; k < casingEffect.size(); k++) {
                                if (casingEffect.size() - 1 == k) {
                                    System.out.print(casingEffect.get(k));
                                    System.out.println();
                                } else {
                                    System.out.print(casingEffect.get(k) + ", ");
                                }
                            }
                        } else {
                            System.out.println("EXAM.Bomb Casings: empty");
                        }

                        System.out.printf("Cherry Bombs: %d\n", cherry);
                        System.out.printf("Datura Bombs: %d\n", datura);
                        System.out.printf("Smoke Decoy Bombs: %d", decoy);
                        return;
                    }
                    break;
                } else if (bombEffect.get(i) + casingEffect.get(j) == 120) {
                    decoy++;
                    bombEffect.remove(i);
                    casingEffect.remove(j);
                    i--;
                    if (datura >= 3 && cherry >= 3 && decoy >= 3) {

                        System.out.println("Bene! You have successfully filled the bomb pouch!");

                        if (!bombEffect.isEmpty()) {
                            System.out.print("EXAM.Bomb Effects: ");
                            for (int k = 0; k < bombEffect.size(); k++) {
                                if (bombEffect.size() - 1 == k) {
                                    System.out.print(bombEffect.get(k));
                                    System.out.println();
                                } else {
                                    System.out.print(bombEffect.get(k) + ", ");
                                }
                            }
                        } else {
                            System.out.println("EXAM.Bomb Effects: empty");
                        }

                        if (!casingEffect.isEmpty()) {
                            System.out.print("EXAM.Bomb Casings: ");
                            for (int k = 0; k < casingEffect.size(); k++) {
                                if (casingEffect.size() - 1 == k) {
                                    System.out.print(casingEffect.get(k));
                                    System.out.println();
                                } else {
                                    System.out.print(casingEffect.get(k) + ", ");
                                }
                            }
                        } else {
                            System.out.println("EXAM.Bomb Casings: empty");
                        }

                        System.out.printf("Cherry Bombs: %d\n", cherry);
                        System.out.printf("Datura Bombs: %d\n", datura);
                        System.out.printf("Smoke Decoy Bombs: %d", decoy);
                        return;
                    }
                    break;
                } else {
                    casingEffect.set(j, casingEffect.get(j) - 5);
                    i--;
                    break;
                }


            }
        }

        System.out.println("You don't have enough materials to fill the bomb pouch.");

        if (!bombEffect.isEmpty()) {
            System.out.print("EXAM.Bomb Effects: ");
            for (int k = 0; k < bombEffect.size(); k++) {
                if (bombEffect.size() - 1 == k) {
                    System.out.print(bombEffect.get(k));
                    System.out.println();
                } else {
                    System.out.print(bombEffect.get(k) + ", ");
                }
            }
        } else {
            System.out.println("EXAM.Bomb Effects: empty");
        }

        if (!casingEffect.isEmpty()) {
            System.out.print("EXAM.Bomb Casings: ");
            for (int k = 0; k < casingEffect.size(); k++) {
                if (casingEffect.size() - 1 == k) {
                    System.out.print(casingEffect.get(k));
                    System.out.println();
                } else {
                    System.out.print(casingEffect.get(k) + ", ");
                }
            }
        } else {
            System.out.println("EXAM.Bomb Casings: empty");
        }
        System.out.printf("Cherry Bombs: %d\n", cherry);
        System.out.printf("Datura Bombs: %d\n", datura);
        System.out.printf("Smoke Decoy Bombs: %d", decoy);
    }


}
