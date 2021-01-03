import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling__05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);
        String[][] matrix = new String[first][second];
        for (int rows = 0; rows < first; rows++) {
            for (int cols = 0; cols < second; cols++) {
                matrix[rows][cols] = scanner.next();
            }
        }
        scanner.nextLine();

        String command = scanner.nextLine();


        while (!command.equals("END")) {
            String[] operations = command.split("\\s+");
            String nameCommand = operations[0];

            swapElementInMatrix(matrix, operations, nameCommand);


            command = scanner.nextLine();
        }

    }

    private static void swapElementInMatrix(String[][] matrix, String[] operations, String nameCommand) {
        switch (nameCommand) {
            case "swap":
                if (operations.length == 5) {
                    int startIndexOne = Integer.parseInt(operations[1]);
                    int startIndexTwo = Integer.parseInt(operations[2]);
                    int swapIndexOne = Integer.parseInt(operations[3]);
                    int swapIndexTwo = Integer.parseInt(operations[4]);

                    if (startIndexOne < matrix.length && startIndexTwo < matrix.length
                            && swapIndexOne < matrix.length && swapIndexTwo < matrix.length) {

                        String firstChange = matrix[startIndexOne][startIndexTwo];
                        String secondChange = matrix[swapIndexOne][swapIndexTwo];
                        matrix[startIndexOne][startIndexTwo] = secondChange;
                        matrix[swapIndexOne][swapIndexTwo] = firstChange;
                        toPrint(matrix);
                    } else {
                        System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("Invalid input!");

                }

                break;

            default:
                System.out.println("Invalid input!");

                break;
        }
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
