import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int inputNum = Integer.parseInt(input[0]);

        int[][] matrix = new int[inputNum][inputNum];

        if (input[1].equals("A")) {
            patternA(inputNum, matrix);


        } else if (input[1].equals("B")) {

            patternB(inputNum, matrix);

        }
    }

    private static void patternB(int inputNum, int[][] matrix) {
        int startNum = 1;


        for (int row = 0; row < inputNum; row++) {


            if (row % 2 == 0) {
                for (int col = 0; col < inputNum; col++) {
                    matrix[col][row] = startNum++;

                }
            } else {
                for (int col = inputNum - 1; col >= 0; col--) {
                    matrix[col][row] = startNum++;

                }
            }

        }
        toPrint(matrix);
    }

    private static void patternA(int inputNum, int[][] matrix) {
        int startNum = 1;

        for (int row = 0; row < inputNum; row++) {
            for (int col = 0; col < inputNum; col++) {
                matrix[col][row] = startNum++;
            }
        }

        toPrint(matrix);
    }

    private static void toPrint(int[][] matrix) {
        for (int rowToPrint = 0; rowToPrint < matrix.length; rowToPrint++) {
            for (int colToPrint = 0; colToPrint < matrix[rowToPrint].length; colToPrint++) {
                System.out.print(matrix[rowToPrint][colToPrint] + " ");
            }
            System.out.println();
        }
    }

}
