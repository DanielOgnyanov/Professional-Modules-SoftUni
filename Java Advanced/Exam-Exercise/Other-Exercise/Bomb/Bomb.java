package EXAM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeMatrix][sizeMatrix];

        List<String> command = Arrays.stream(scanner.nextLine().split(","))
                .collect(Collectors.toCollection(ArrayList::new));


        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {
                String[] curr = scanner.nextLine().split("\\s+");
                matrix[col] = curr;
            }
            break;
        }


        int indexRow = 0;
        int indexCol = 0;

        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {                     // Find Start Index
                if (matrix[row][col].equals("s")) {
                    indexRow = row;
                    indexCol = col;
                    break;
                }
            }
        }


        int countBomb = 0;
        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {                     // Find All EXAM.Bomb
                if (matrix[row][col].equals("B")) {
                    countBomb++;
                }
            }
        }


        while (!command.isEmpty()) {

            String currCommand = command.get(0);

            switch (currCommand) {

                case "right":
                    if (indexCol + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = "+";
                        indexCol += 1;  // check if i receive not 100

                        if (matrix[indexRow][indexCol].equals("B")) {

                            matrix[indexRow][indexCol] = "+";
                            countBomb--;
                            System.out.println("You found a bomb!");
                            if (countBomb == 0) {
                                System.out.println("Congratulations! You found all bombs!");
                                return;
                            }

                        } else if (matrix[indexRow][indexCol].equals("e")) {
                            indexCol -= 1;
                            System.out.printf("END! %d bombs left on the field\n", countBomb);
                            return;


                        } else if (matrix[indexRow][indexCol].equals("+")) {
                            matrix[indexRow][indexCol] = "s";
                        }


                    }
                    break;

                case "left":
                    if (indexCol - 1 >= 0) {
                        matrix[indexRow][indexCol] = "+";
                        indexCol -= 1;

                        if (matrix[indexRow][indexCol].equals("B")) {

                            matrix[indexRow][indexCol] = "+";
                            countBomb--;
                            System.out.println("You found a bomb!");
                            if (countBomb == 0) {
                                System.out.println("Congratulations! You found all bombs!");
                                return;
                            }

                        } else if (matrix[indexRow][indexCol].equals("e")) {
                            indexCol += 1;
                            System.out.printf("END! %d bombs left on the field\n", countBomb);
                            return;


                        } else if (matrix[indexRow][indexCol].equals("+")) {
                            matrix[indexRow][indexCol] = "s";
                        }

                    }
                    break;

                case "up":
                    if (indexRow - 1 >= 0) {
                        matrix[indexRow][indexCol] = "+";
                        indexRow -= 1;

                        if (matrix[indexRow][indexCol].equals("B")) {

                            matrix[indexRow][indexCol] = "+";
                            countBomb--;
                            System.out.println("You found a bomb!");
                            if (countBomb == 0) {
                                System.out.println("Congratulations! You found all bombs!");
                                return;
                            }

                        } else if (matrix[indexRow][indexCol].equals("e")) {
                            indexRow += 1;
                            System.out.printf("END! %d bombs left on the field\n", countBomb);
                            return;


                        } else if (matrix[indexRow][indexCol].equals("+")) {
                            matrix[indexRow][indexCol] = "s";
                        }
                    }
                    break;

                case "down":
                    if (indexRow + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = "+";
                        indexRow += 1;

                        if (matrix[indexRow][indexCol].equals("B")) {

                            matrix[indexRow][indexCol] = "+";
                            countBomb--;
                            System.out.println("You found a bomb!");
                            if (countBomb == 0) {
                                System.out.println("Congratulations! You found all bombs!");
                                return;
                            }

                        } else if (matrix[indexRow][indexCol].equals("e")) {
                            indexRow -= 1;
                            System.out.printf("END! %d bombs left on the field\n", countBomb);
                            return;


                        } else if (matrix[indexRow][indexCol].equals("+")) {
                            matrix[indexRow][indexCol] = "s";
                        }

                    }
                    break;


            }
            command.remove(0);
        }


        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countBomb, indexRow, indexCol);


    }

    private static void toPrint(String[][] matrix) {
        for (int rowToPrint = 0; rowToPrint < matrix.length; rowToPrint++) {
            for (int colToPrint = 0; colToPrint < matrix[rowToPrint].length; colToPrint++) {
                System.out.print(matrix[rowToPrint][colToPrint] + " ");
            }
            System.out.println();
        }
    }

}
