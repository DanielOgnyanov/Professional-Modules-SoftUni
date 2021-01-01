import java.util.Scanner;

public class DiagonalDifference__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // NxN

        int input = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[input][input];

        for (int row = 0; row < input; row++) {
            for (int col = 0; col < input; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        int initialNumPrimary = matrix[0][0];
        int i = 1;
        int count = 1;
        while (matrix.length > i) {
            initialNumPrimary += matrix[count][count];
            count++;
            i++;
        }
        i = 1;
        int initialNumSecondary = matrix[matrix.length - 1][0];
        int countColl = 1;
        int countRow = matrix.length - 2;
        while (matrix.length > i) {
            int curr = matrix[countRow][countColl];
            initialNumSecondary += curr;
            countColl++;
            countRow--;
            i++;
        }

        System.out.println(Math.abs(initialNumPrimary - initialNumSecondary));
    }

}
