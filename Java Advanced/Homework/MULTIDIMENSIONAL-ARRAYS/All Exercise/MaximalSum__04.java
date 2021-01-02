import java.util.*;

public class MaximalSum__04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);
        int[][] matrix = new int[first][second];
        int[][] currMatrix = new int[3][3];
        int[][] toPrint = new int[3][3];
        int max = 0;

        for (int rows = 0; rows < first; rows++) {
            for (int cols = 0; cols < second; cols++) {
                matrix[rows][cols] = scanner.nextInt();
            }
        }
        int sum = 0;
        int count = 0;
        int update = 0;
        int toStop = 3;
        int rowUpdate = 0;
        int indexOne = 0;
        int indexTwo = 0;

        while (true) {
            VerifyMatrixAndCloneMatrix verifyMatrixAndCloneMatrix =
                    new VerifyMatrixAndCloneMatrix(second, currMatrix, matrix, sum, count,
                            update, toStop, rowUpdate, indexOne, indexTwo).invoke();
            if (verifyMatrixAndCloneMatrix.is())
                break;
            sum = verifyMatrixAndCloneMatrix.getSum();
            count = verifyMatrixAndCloneMatrix.getCount();
            update = verifyMatrixAndCloneMatrix.getUpdate();
            toStop = verifyMatrixAndCloneMatrix.getToStop();
            rowUpdate = verifyMatrixAndCloneMatrix.getRowUpdate();
            indexOne = verifyMatrixAndCloneMatrix.getIndexOne();
            CheckMaxSum checkMaxSum = new CheckMaxSum(currMatrix, toPrint, max, sum).invoke();
            currMatrix = checkMaxSum.getCurrMatrix();
            max = checkMaxSum.getMax();

            count++;
            update++;
            toStop++;
            indexTwo = 0;
            sum = 0;

        }


        System.out.printf("Sum = %d\n", max);
        toPrint(toPrint);

    }

    private static void toPrint(int[][] matrix) {
        for (int rowToPrint = 0; rowToPrint < matrix.length; rowToPrint++) {
            for (int colToPrint = 0; colToPrint < matrix[rowToPrint].length; colToPrint++) {
                System.out.print(matrix[rowToPrint][colToPrint] + " ");
            }
            System.out.println();
        }
    }

    private static class VerifyMatrixAndCloneMatrix {
        private boolean myResult;
        private int second;
        private int[][] currMatrix;
        private int[][] matrix;
        private int sum;
        private int count;
        private int update;
        private int toStop;
        private int rowUpdate;
        private int indexOne;
        private int indexTwo;

        public VerifyMatrixAndCloneMatrix(int second, int[][] currMatrix, int[][] matrix, int sum, int count, int update, int toStop, int rowUpdate, int indexOne, int indexTwo) {
            this.second = second;
            this.currMatrix = currMatrix;
            this.matrix = matrix;
            this.sum = sum;
            this.count = count;
            this.update = update;
            this.toStop = toStop;
            this.rowUpdate = rowUpdate;
            this.indexOne = indexOne;
            this.indexTwo = indexTwo;
        }

        boolean is() {
            return myResult;
        }

        public int getSum() {
            return sum;
        }

        public int getCount() {
            return count;
        }

        public int getUpdate() {
            return update;
        }

        public int getToStop() {
            return toStop;
        }

        public int getRowUpdate() {
            return rowUpdate;
        }

        public int getIndexOne() {
            return indexOne;
        }

        public VerifyMatrixAndCloneMatrix invoke() {
            if (second - 2 == count) {
                rowUpdate++;
                count = 0;
                update = 0;
                toStop = 3;
            }
            if (rowUpdate + 3 > matrix.length) {
                myResult = true;
                return this;
            }
            for (int row = rowUpdate; row < rowUpdate + 3; row++) {
                for (int col = update; col < toStop; col++) {
                    int curr = matrix[row][col];
                    currMatrix[indexOne][indexTwo] = curr;
                    indexTwo++;
                    sum += curr;
                }
                indexTwo = 0;
                indexOne++;
            }
            indexOne = 0;
            myResult = false;
            return this;
        }
    }

    private static class CheckMaxSum {
        private int[][] currMatrix;
        private int[][] toPrint;
        private int max;
        private int sum;

        public CheckMaxSum(int[][] currMatrix, int[][] toPrint, int max, int sum) {
            this.currMatrix = currMatrix;
            this.toPrint = toPrint;
            this.max = max;
            this.sum = sum;
        }

        public int[][] getCurrMatrix() {
            return currMatrix;
        }

        public int getMax() {
            return max;
        }

        public CheckMaxSum invoke() {
            if (sum > max) {
                max = sum;

                for (int cols = 0; cols < currMatrix.length; cols++) {
                    toPrint[cols] = currMatrix[cols].clone();
                }
                currMatrix = new int[3][3];
            } else {
                currMatrix = new int[3][3];
            }
            return this;
        }
    }
}
