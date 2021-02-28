package EXAM.Exam28June2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[sizeMatrix][sizeMatrix];
        List<String> infoSave = new ArrayList<>();
        for (int i = 0; i < sizeMatrix; i++) {                              // SAVE ALL ROWS IN LIST TO ADD THEM AFTER
            String command = scanner.nextLine();
            infoSave.add(command);
        }

        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {
                String[] currRow = infoSave.get(col).split("");        // Fill Matrix
                matrix[col] = currRow;
            }
            break;
        }


        int indexRow = 0;
        int indexCol = 0;

        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {                 // Find Index Snake In The Matrix Position
                if (matrix[row][col].equals("S")) {
                    indexRow = row;
                    indexCol = col;
                    break;
                }
            }
        }

        int indexRowLair = 0;
        int indexColLair = 0;
        int indexRowLairTwo = 0;
        int indexColLairTwo = 0;
        int countLair = 0;
        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {                 // Find Index Lair In The Matrix
                if (matrix[row][col].equals("B")) {
                    if (countLair == 0) {
                        indexRowLair = row;
                        indexColLair = col;
                        countLair++;
                    }
                    if (countLair == 1) {
                        indexRowLairTwo = row;
                        indexColLairTwo = col;
                        break;
                    }
                }
            }
        }


        String typeOfCommand = scanner.nextLine();
        int food = 0;
        while (true) {
            switch (typeOfCommand) {

                case "right":
                    if (indexCol + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = ".";
                        indexCol += 1;
                        switch (matrix[indexRow][indexCol]) {
                            case "*":
                                food++;
                                matrix[indexRow][indexCol] = "S";
                                if (food >= 10) {
                                    System.out.println("You won! You fed the snake.");
                                    System.out.printf("Food eaten: %d\n", food);
                                    toPrintGenericMATRIX(matrix);
                                    return;
                                }
                                break;
                            case "B":
                                matrix[indexRow][indexCol] = ".";
                                if ((indexRow + indexCol) == (indexRowLair + indexColLair)) {
                                    indexRow = indexRowLairTwo;
                                    indexCol = indexColLairTwo;
                                    matrix[indexRow][indexCol] = "S";
                                } else if ((indexRow + indexCol) == (indexRowLairTwo + indexColLairTwo)) {
                                    indexRow = indexRowLair;
                                    indexCol = indexColLair;
                                    matrix[indexRow][indexCol] = "S";
                                }


                                break;
                            case "-":
                                matrix[indexRow][indexCol] = "S";
                                break;
                        }
                    } else {
                        matrix[indexRow][indexCol] = ".";
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d\n", food);
                        toPrintGenericMATRIX(matrix);
                        return;

                    }
                    break;

                case "left":
                    if (indexCol - 1 >= 0) {
                        matrix[indexRow][indexCol] = ".";
                        indexCol -= 1;
                        switch (matrix[indexRow][indexCol]) {
                            case "*":
                                food++;
                                matrix[indexRow][indexCol] = "S";
                                if (food >= 10) {
                                    System.out.println("You won! You fed the snake.");
                                    System.out.printf("Food eaten: %d\n", food);
                                    toPrintGenericMATRIX(matrix);
                                    return;
                                }
                                break;
                            case "B":
                                matrix[indexRow][indexCol] = ".";
                                if ((indexRow + indexCol) == (indexRowLair + indexColLair)) {
                                    indexRow = indexRowLairTwo;
                                    indexCol = indexColLairTwo;
                                    matrix[indexRow][indexCol] = "S";
                                } else if ((indexRow + indexCol) == (indexRowLairTwo + indexColLairTwo)) {
                                    indexRow = indexRowLair;
                                    indexCol = indexColLair;
                                    matrix[indexRow][indexCol] = "S";
                                }


                                break;
                            case "-":
                                matrix[indexRow][indexCol] = "S";
                                break;
                        }


                    } else {
                        matrix[indexRow][indexCol] = ".";
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d\n", food);
                        toPrintGenericMATRIX(matrix);
                        return;
                    }
                    break;
                case "up":
                    if (indexRow - 1 >= 0) {
                        matrix[indexRow][indexCol] = ".";
                        indexRow -= 1;
                        switch (matrix[indexRow][indexCol]) {
                            case "*":
                                food++;
                                matrix[indexRow][indexCol] = "S";
                                if (food >= 10) {
                                    System.out.println("You won! You fed the snake.");
                                    System.out.printf("Food eaten: %d\n", food);
                                    toPrintGenericMATRIX(matrix);
                                    return;
                                }
                                break;
                            case "B":
                                matrix[indexRow][indexCol] = ".";
                                if ((indexRow + indexCol) == (indexRowLair + indexColLair)) {
                                    indexRow = indexRowLairTwo;
                                    indexCol = indexColLairTwo;
                                    matrix[indexRow][indexCol] = "S";
                                } else if ((indexRow + indexCol) == (indexRowLairTwo + indexColLairTwo)) {
                                    indexRow = indexRowLair;
                                    indexCol = indexColLair;
                                    matrix[indexRow][indexCol] = "S";
                                }


                                break;
                            case "-":
                                matrix[indexRow][indexCol] = "S";
                                break;
                        }

                    } else {
                        matrix[indexRow][indexCol] = ".";
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d\n", food);
                        toPrintGenericMATRIX(matrix);
                        return;
                    }
                    break;
                case "down":
                    if (indexRow + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = ".";
                        indexRow += 1;
                        switch (matrix[indexRow][indexCol]) {
                            case "*":
                                food++;
                                matrix[indexRow][indexCol] = "S";
                                if (food >= 10) {
                                    System.out.println("You won! You fed the snake.");
                                    System.out.printf("Food eaten: %d\n", food);
                                    toPrintGenericMATRIX(matrix);
                                    return;
                                }
                                break;
                            case "B":
                                matrix[indexRow][indexCol] = ".";
                                if ((indexRow + indexCol) == (indexRowLair + indexColLair)) {
                                    indexRow = indexRowLairTwo;
                                    indexCol = indexColLairTwo;
                                    matrix[indexRow][indexCol] = "S";
                                } else if ((indexRow + indexCol) == (indexRowLairTwo + indexColLairTwo)) {
                                    indexRow = indexRowLair;
                                    indexCol = indexColLair;
                                    matrix[indexRow][indexCol] = "S";
                                }


                                break;
                            case "-":
                                matrix[indexRow][indexCol] = "S";
                                break;
                        }

                    } else {
                        matrix[indexRow][indexCol] = ".";
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d\n", food);
                        toPrintGenericMATRIX(matrix);
                        return;
                    }
                    break;

            }
            typeOfCommand = scanner.nextLine();
        }


    }

    private static void toPrintGenericMATRIX(String[][] matrix) {
        for (int rowToPrint = 0; rowToPrint < matrix.length; rowToPrint++) {
            for (int colToPrint = 0; colToPrint < matrix[rowToPrint].length; colToPrint++) {
                System.out.print(matrix[rowToPrint][colToPrint]);
            }
            System.out.println();
        }
    }
}
