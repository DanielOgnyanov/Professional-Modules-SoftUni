package EXAM.Exam22Feb2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReVolt__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        int countLine = Integer.parseInt(scanner.nextLine());

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
                if (matrix[row][col].equals("f")) {
                    indexRow = row;
                    indexCol = col;
                    break;
                }
            }
        }

        String typeOfCommand = scanner.nextLine();
        int time = 0;
        while (true) {
            switch (typeOfCommand) {
                case "right":///////////////////////////
                    if (indexCol + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = "-";
                        indexCol += 1;
                        switch (matrix[indexRow][indexCol]) {
                            case "-":
                                matrix[indexRow][indexCol] = "f";
                                break;
                            case "B":
                                matrix[indexRow][indexCol] = "B";
                                indexCol += 1;
                                if (indexCol + 1 > sizeMatrix - 1) {
                                    indexCol = 0;
                                    if (matrix[indexRow][indexCol].equals("-")) {
                                        matrix[indexRow][indexCol] = "f";
                                    } else if (matrix[indexRow][indexCol].equals("F")) {
                                        matrix[indexRow][indexCol] = "f";
                                        System.out.println("Player won!");
                                        toPrintGenericMATRIX(matrix);
                                        return;
                                    }
                                }
                                if (matrix[indexRow][indexCol].equals("-")) {
                                    matrix[indexRow][indexCol] = "f";
                                } else if (matrix[indexRow][indexCol].equals("F")) {
                                    matrix[indexRow][indexCol] = "f";
                                    System.out.println("Player won!");
                                    toPrintGenericMATRIX(matrix);

                                }

                                break;
                            case "F":
                                matrix[indexRow][indexCol] = "f";
                                System.out.println("Player won!");
                                toPrintGenericMATRIX(matrix);
                                return;
                            case "T":
                                indexCol -= 1;
                                matrix[indexRow][indexCol] = "f";
                                break;
                        }
                    } else {
                        matrix[indexRow][indexCol] = "-";
                        indexCol = 0;
                        if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "f";
                        } else if (matrix[indexRow][indexCol].equals("F")) {
                            matrix[indexRow][indexCol] = "f";
                            System.out.println("Player won!");
                            toPrintGenericMATRIX(matrix);
                            return;
                        }
                    }
                    break;
                case "left": ////////////////////////
                    if (indexCol - 1 >= 0) {
                        matrix[indexRow][indexCol] = "-";
                        indexCol -= 1;
                        switch (matrix[indexRow][indexCol]) {
                            case "-":
                                matrix[indexRow][indexCol] = "f";
                                break;
                            case "B":
                                matrix[indexRow][indexCol] = "B";
                                indexCol -= 1;

                                if (indexCol - 1 < 0) {
                                    indexCol = sizeMatrix - 1;
                                    if (matrix[indexRow][indexCol].equals("-")) {
                                        matrix[indexRow][indexCol] = "f";
                                    } else if (matrix[indexRow][indexCol].equals("F")) {
                                        matrix[indexRow][indexCol] = "f";
                                        System.out.println("Player won!");
                                        toPrintGenericMATRIX(matrix);
                                        return;
                                    }
                                }

                                if (matrix[indexRow][indexCol].equals("-")) {
                                    matrix[indexRow][indexCol] = "f";
                                } else if (matrix[indexRow][indexCol].equals("F")) {
                                    matrix[indexRow][indexCol] = "f";
                                    System.out.println("Player won!");
                                    toPrintGenericMATRIX(matrix);
                                    return;
                                }

                                break;
                            case "F":
                                matrix[indexRow][indexCol] = "f";
                                System.out.println("Player won!");
                                toPrintGenericMATRIX(matrix);
                                return;
                            case "T":
                                indexCol += 1;
                                matrix[indexRow][indexCol] = "f";
                                break;
                        }
                    } else {
                        matrix[indexRow][indexCol] = "-";
                        indexCol = sizeMatrix - 1;
                        if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "f";
                        } else if (matrix[indexRow][indexCol].equals("F")) {
                            matrix[indexRow][indexCol] = "f";
                            System.out.println("Player won!");
                            toPrintGenericMATRIX(matrix);
                            return;
                        }
                    }
                    break;
                case "up":////////////////////////////////////////////
                    if (indexRow - 1 >= 0) {
                        matrix[indexRow][indexCol] = "-";
                        indexRow -= 1;
                        switch (matrix[indexRow][indexCol]) {
                            case "-":
                                matrix[indexRow][indexCol] = "f";
                                break;
                            case "B":
                                matrix[indexRow][indexCol] = "B";
                                indexRow -= 1;
                                if (indexRow - 1 < 0) {
                                    indexRow = sizeMatrix - 1;
                                    if (matrix[indexRow][indexCol].equals("-")) {
                                        matrix[indexRow][indexCol] = "f";
                                    } else if (matrix[indexRow][indexCol].equals("F")) {
                                        matrix[indexRow][indexCol] = "f";
                                        System.out.println("Player won!");
                                        toPrintGenericMATRIX(matrix);
                                        return;
                                    }
                                }
                                if (matrix[indexRow][indexCol].equals("-")) {
                                    matrix[indexRow][indexCol] = "f";
                                } else if (matrix[indexRow][indexCol].equals("F")) {
                                    matrix[indexRow][indexCol] = "f";
                                    System.out.println("Player won!");
                                    toPrintGenericMATRIX(matrix);

                                }

                                break;
                            case "F":
                                matrix[indexRow][indexCol] = "f";
                                System.out.println("Player won!");
                                toPrintGenericMATRIX(matrix);
                                return;
                            case "T":
                                indexRow += 1;
                                matrix[indexRow][indexCol] = "f";
                                break;
                        }
                    } else {
                        matrix[indexRow][indexCol] = "-";
                        indexRow = sizeMatrix - 1;
                        if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "f";
                        } else if (matrix[indexRow][indexCol].equals("F")) {
                            matrix[indexRow][indexCol] = "f";
                            System.out.println("Player won!");
                            toPrintGenericMATRIX(matrix);
                            return;
                        }

                    }
                    break;
                case "down":
                    if (indexRow + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = "-";
                        indexRow += 1;
                        switch (matrix[indexRow][indexCol]) {
                            case "-":
                                matrix[indexRow][indexCol] = "f";
                                break;
                            case "B":
                                matrix[indexRow][indexCol] = "B";
                                indexRow += 1;
                                if (indexRow + 1 > sizeMatrix - 1) {
                                    indexRow = 0;
                                    if (matrix[indexRow][indexCol].equals("-")) {
                                        matrix[indexRow][indexCol] = "f";
                                    } else if (matrix[indexRow][indexCol].equals("F")) {
                                        matrix[indexRow][indexCol] = "f";
                                        System.out.println("Player won!");
                                        toPrintGenericMATRIX(matrix);
                                        return;
                                    }
                                }
                                if (matrix[indexRow][indexCol].equals("-")) {
                                    matrix[indexRow][indexCol] = "f";
                                } else if (matrix[indexRow][indexCol].equals("F")) {
                                    matrix[indexRow][indexCol] = "f";
                                    System.out.println("Player won!");
                                    toPrintGenericMATRIX(matrix);

                                }

                                break;
                            case "F":
                                matrix[indexRow][indexCol] = "f";
                                System.out.println("Player won!");
                                toPrintGenericMATRIX(matrix);
                                return;
                            case "T":
                                indexRow -= 1;
                                matrix[indexRow][indexCol] = "f";
                                break;
                        }
                    } else {
                        matrix[indexRow][indexCol] = "-";
                        indexRow = 0;
                        if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "f";
                        } else if (matrix[indexRow][indexCol].equals("F")) {
                            matrix[indexRow][indexCol] = "f";
                            System.out.println("Player won!");
                            toPrintGenericMATRIX(matrix);
                            return;
                        }
                    }
                    break;
            }
            time++;
            if (time == countLine) {
                break;
            }
            typeOfCommand = scanner.nextLine();
        }

        System.out.println("Player lost!");
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
