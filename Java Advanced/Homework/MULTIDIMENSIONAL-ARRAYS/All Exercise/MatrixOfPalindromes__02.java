import java.util.Scanner;

public class MatrixOfPalindromes__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        char initial = 'a';
        char mid = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + initial + mid + initial;
                mid = (char) (mid + 1);
            }
            initial = (char) (initial + 1);
            mid = initial;
        }

        toPrint(matrix);
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
