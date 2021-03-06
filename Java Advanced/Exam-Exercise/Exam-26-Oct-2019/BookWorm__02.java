package EXAM.Exam26Oct2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookWorm__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialWord = scanner.nextLine();
        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeMatrix][];
        List<String> infoSave = new ArrayList<>();
        for (int i = 0; i < sizeMatrix; i++) {                          // SAVE ALL ROWS IN LIST TO ADD THEM AFTER
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
            for (int col = 0; col < sizeMatrix; col++) {                 // Find Index Player
                if (matrix[row][col].equals("P")) {
                    indexRow = row;
                    indexCol = col;
                    break;
                }
            }
        }
        StringBuilder toPrint = new StringBuilder(initialWord);
        String typeOfCommand = scanner.nextLine();
        while (!typeOfCommand.equals("end")) {
            switch (typeOfCommand) {

                case "right":
                    if (indexCol + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = "-";
                        indexCol += 1;

                        if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "P";
                        } else {
                            toPrint.append(matrix[indexRow][indexCol]);
                            matrix[indexRow][indexCol] = "P";
                        }
                    } else {
                        if (toPrint.length() != 0) {
                            toPrint.setLength(toPrint.length() - 1);
                        }
                    }
                    break;

                case "left":
                    if (indexCol - 1 >= 0) {
                        matrix[indexRow][indexCol] = "-";
                        indexCol -= 1;

                        if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "P";
                        } else {
                            toPrint.append(matrix[indexRow][indexCol]);
                            matrix[indexRow][indexCol] = "P";
                        }
                    } else {
                        if (toPrint.length() != 0) {
                            toPrint.setLength(toPrint.length() - 1);
                        }
                    }
                    break;

                case "up":
                    if (indexRow - 1 >= 0) {
                        matrix[indexRow][indexCol] = "-";
                        indexRow -= 1;

                        if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "P";
                        } else {
                            toPrint.append(matrix[indexRow][indexCol]);
                            matrix[indexRow][indexCol] = "P";
                        }
                    } else {
                        if (toPrint.length() != 0) {
                            toPrint.setLength(toPrint.length() - 1);
                        }
                    }
                    break;

                case "down":
                    if (indexRow + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = "-";
                        indexRow += 1;

                        if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "P";
                        } else {
                            toPrint.append(matrix[indexRow][indexCol]);
                            matrix[indexRow][indexCol] = "P";
                        }
                    } else {
                        if (toPrint.length() != 0) {
                            toPrint.setLength(toPrint.length() - 1);
                        }
                    }
                    break;
            }


            typeOfCommand = scanner.nextLine();
        }

        System.out.println(toPrint);
        toPrintGenericMATRIX(matrix);
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
