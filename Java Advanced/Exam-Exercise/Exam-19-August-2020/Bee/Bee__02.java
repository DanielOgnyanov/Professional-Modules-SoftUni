package EXAM.Exam19August2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bee__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[sizeMatrix][sizeMatrix];
        List<String> infoSave = new ArrayList<>();
        for (int i = 0; i < sizeMatrix; i++) {
            String command = scanner.nextLine();
            infoSave.add(command);
        }

        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {
                String[] currRow = infoSave.get(col).split("");          // Fill Matrix
                matrix[col] = currRow;
            }
            break;
        }
        int indexRow = 0;
        int indexCol = 0;

        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {                     // Find Index Bee
                if (matrix[row][col].equals("B")) {
                    indexRow = row;
                    indexCol = col;
                    break;
                }
            }
        }

        String typeOfCommand = scanner.nextLine();
        int pollinated = 0;
        while (!typeOfCommand.equals("End")) {

            switch (typeOfCommand) {

                case "right":
                    if (indexCol + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = ".";
                        indexCol += 1;
                        if (matrix[indexRow][indexCol].equals("f")) {
                            pollinated++;
                            matrix[indexRow][indexCol] = "B";
                        } else if (matrix[indexRow][indexCol].equals("O")) {
                            matrix[indexRow][indexCol] = ".";
                            indexCol += 1;
                            if (matrix[indexRow][indexCol].equals("f")) {
                                pollinated++;
                                matrix[indexRow][indexCol] = "B";
                            } else {
                                matrix[indexRow][indexCol] = "B";
                            }
                        } else {
                            matrix[indexRow][indexCol] = "B";
                        }
                    } else {
                        matrix[indexRow][indexCol] = ".";
                        System.out.println("The bee got lost!");
                        if (pollinated >= 5) {
                            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinated);
                        } else {
                            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinated);
                        }
                        toPrint(matrix);
                        return;
                    }
                    break;

                case "left":
                    if (indexCol - 1 >= 0) {
                        matrix[indexRow][indexCol] = ".";
                        indexCol -= 1;
                        if (matrix[indexRow][indexCol].equals("f")) {
                            pollinated++;
                            matrix[indexRow][indexCol] = "B";
                        } else if (matrix[indexRow][indexCol].equals("O")) {
                            matrix[indexRow][indexCol] = ".";
                            indexCol -= 1;
                            if (matrix[indexRow][indexCol].equals("f")) {
                                pollinated++;
                                matrix[indexRow][indexCol] = "B";
                            } else {
                                matrix[indexRow][indexCol] = "B";
                            }
                        } else {
                            matrix[indexRow][indexCol] = "B";
                        }

                    } else {
                        matrix[indexRow][indexCol] = ".";
                        System.out.println("The bee got lost!");
                        if (pollinated >= 5) {
                            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinated);
                        } else {
                            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinated);
                        }
                        toPrint(matrix);
                        return;
                    }
                    break;

                case "up":
                    if (indexRow - 1 >= 0) {
                        matrix[indexRow][indexCol] = ".";
                        indexRow -= 1;
                        if (matrix[indexRow][indexCol].equals("f")) {
                            pollinated++;
                            matrix[indexRow][indexCol] = "B";
                        } else if (matrix[indexRow][indexCol].equals("O")) {
                            matrix[indexRow][indexCol] = ".";
                            indexRow -= 1;
                            if (matrix[indexRow][indexCol].equals("f")) {
                                pollinated++;
                                matrix[indexRow][indexCol] = "B";
                            } else {
                                matrix[indexRow][indexCol] = "B";
                            }
                        } else {
                            matrix[indexRow][indexCol] = "B";
                        }
                    } else {
                        matrix[indexRow][indexCol] = ".";
                        System.out.println("The bee got lost!");
                        if (pollinated >= 5) {
                            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinated);
                        } else {
                            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinated);
                        }
                        toPrint(matrix);
                        return;
                    }

                    break;

                case "down":
                    if (indexRow + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = ".";
                        indexRow += 1;
                        if (matrix[indexRow][indexCol].equals("f")) {
                            pollinated++;
                            matrix[indexRow][indexCol] = "B";
                        } else if (matrix[indexRow][indexCol].equals("O")) {
                            matrix[indexRow][indexCol] = ".";
                            indexRow += 1;
                            if (matrix[indexRow][indexCol].equals("f")) {
                                pollinated++;
                                matrix[indexRow][indexCol] = "B";
                            } else {
                                matrix[indexRow][indexCol] = "B";
                            }
                        } else {
                            matrix[indexRow][indexCol] = "B";
                        }

                    } else {
                        matrix[indexRow][indexCol] = ".";
                        System.out.println("The bee got lost!");
                        if (pollinated >= 5) {
                            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinated);
                        } else {
                            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinated);
                        }
                        toPrint(matrix);
                        return;
                    }
                    break;

            }


            typeOfCommand = scanner.nextLine();
        }

        if (pollinated >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinated);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinated);
        }
        toPrint(matrix);

    }

    private static void toPrint(String[][] matrix) {
        for (int rowToPrint = 0; rowToPrint < matrix.length; rowToPrint++) {
            for (int colToPrint = 0; colToPrint < matrix[rowToPrint].length; colToPrint++) {
                System.out.print(matrix[rowToPrint][colToPrint]);
            }
            System.out.println();
        }
    }
}
