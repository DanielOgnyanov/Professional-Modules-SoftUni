package WorkingWithAbstraction.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int x = matrixSize[0];
        int y = matrixSize[1];

        int[][] matrix = fillMatrix(x, y);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] ivoIndexPosition = Arrays.stream(command.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int rowIvo = ivoIndexPosition[0];
            int colIvo = ivoIndexPosition[1];


            int[] evilIndexPosition = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int rowEvil = evilIndexPosition[0];
            int colEvil = evilIndexPosition[1];

            evilDestroyingStar(matrix, rowEvil, colEvil);

            sum = ivoCollectStar(matrix, sum, rowIvo, colIvo);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long ivoCollectStar(int[][] matrix, long sum, int rowIvo, int colIvo) {
        while (rowIvo >= 0 && colIvo < matrix[1].length) {
            if (rowIvo >= 0 && rowIvo < matrix.length && colIvo >= 0 && colIvo < matrix[0].length) {
                sum += matrix[rowIvo][colIvo];
            }

            colIvo++;
            rowIvo--;
        }
        return sum;
    }

    private static void evilDestroyingStar(int[][] matrix, int rowEvil, int colEvil) {
        while (rowEvil >= 0 && colEvil >= 0)
        {
            if (rowEvil >= 0 && rowEvil < matrix.length && colEvil >= 0 && colEvil < matrix[0].length)
            {
                matrix[rowEvil] [colEvil] = 0;
            }
            rowEvil--;
            colEvil--;
        }
    }

    private static int[][] fillMatrix(int x, int y) {
        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

}
