package EXAM.Exam17Dec2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countGift = Integer.parseInt(scanner.nextLine());
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[sizeMatrix][sizeMatrix];
        List<String> infoSave = new ArrayList<>();
        for (int i = 0; i < sizeMatrix; i++) {
            String command = scanner.nextLine();
            infoSave.add(command);
        }
        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {
                String[] currRow = infoSave.get(col).split(" ");          // Fill Matrix By Colon in
                matrix[col] = currRow;                                          // directions down
            }
            break;
        }
        int indexRow = 0;
        int indexCol = 0;
        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {                     // Find Index Santa
                if (matrix[row][col].equals("S")) {
                    indexRow = row;
                    indexCol = col;
                    break;
                }
            }
        }
        int niceKidCount = 0;
        int saveNum = niceKidCount;
        int countGiftReceive = 0;
        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {                     // Find All Nice Kids Count
                if (matrix[row][col].equals("V")) {
                    niceKidCount++;
                }
            }
        }
        String typeOfCommand = scanner.nextLine();
        while (!typeOfCommand.equals("Christmas morning")) {
            switch (typeOfCommand) {
                case "right":
                    if (indexCol + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = "-";
                        indexCol += 1;
                        if (matrix[indexRow][indexCol].equals("X")) {
                            matrix[indexRow][indexCol] = "S";
                        } else if (matrix[indexRow][indexCol].equals("V")) {
                            matrix[indexRow][indexCol] = "S";
                            niceKidCount--;
                            countGiftReceive++;
                            countGift--;
                            if (outOfPresentsCheck(countGift, matrix, niceKidCount, countGiftReceive, saveNum)) {
                                return;
                            }
                        } else if (matrix[indexRow][indexCol].equals("C")) {
                            int savePositionSantaRow = indexRow;
                            int savePositionSantaCol = indexCol;
                            matrix[indexRow][indexCol] = "S";
                            CookieCheck cookieCheck = new CookieCheck(countGift, sizeMatrix, matrix, indexRow, indexCol, niceKidCount, countGiftReceive, savePositionSantaRow, savePositionSantaCol).invoke();
                            if (cookieCheck.is()) return;
                            countGift = cookieCheck.getCountGift();
                            niceKidCount = cookieCheck.getNiceKidCount();
                            countGiftReceive = cookieCheck.getCountGiftReceive();
                            if (outOfPresentsCheck(countGift, matrix, niceKidCount, countGiftReceive, saveNum)) {
                                return;
                            }
                        } else if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "S";
                        }
                    } else {
                        System.out.println("Santa ran out of presents!");
                        toPrint(matrix);
                        if (niceKidCount <= 0) {
                            System.out.printf("Good job, Santa! %d happy nice kid/s.", countGiftReceive - niceKidCount);
                        } else {
                            System.out.printf("No presents for %d nice kid/s.", niceKidCount);
                        }
                        return;
                    }
                    break;
                case "left":
                    if (indexCol - 1 >= 0) {
                        matrix[indexRow][indexCol] = "-";
                        indexCol -= 1;
                        if (matrix[indexRow][indexCol].equals("X")) {
                            matrix[indexRow][indexCol] = "S";
                        } else if (matrix[indexRow][indexCol].equals("V")) {
                            matrix[indexRow][indexCol] = "S";
                            niceKidCount--;
                            countGiftReceive++;
                            countGift--;
                            if (outOfPresentsCheck(countGift, matrix, niceKidCount, countGiftReceive, saveNum)) {
                                return;
                            }
                        } else if (matrix[indexRow][indexCol].equals("C")) {
                            int savePositionSantaRow = indexRow;
                            int savePositionSantaCol = indexCol;
                            matrix[indexRow][indexCol] = "S";
                            CookieCheck cookieCheck = new CookieCheck(countGift, sizeMatrix, matrix, indexRow, indexCol, niceKidCount, countGiftReceive, savePositionSantaRow, savePositionSantaCol).invoke();
                            if (cookieCheck.is())
                                return;
                            countGift = cookieCheck.getCountGift();
                            niceKidCount = cookieCheck.getNiceKidCount();
                            countGiftReceive = cookieCheck.getCountGiftReceive();
                            if (outOfPresentsCheck(countGift, matrix, niceKidCount, countGiftReceive, saveNum)) {
                                return;
                            }
                        } else if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "S";
                        }
                    } else {
                        System.out.println("Santa ran out of presents!");
                        toPrint(matrix);
                        if (niceKidCount <= 0) {
                            System.out.printf("Good job, Santa! %d happy nice kid/s.", countGiftReceive - niceKidCount);
                        } else {
                            System.out.printf("No presents for %d nice kid/s.", niceKidCount);
                        }
                        return;
                    }
                    break;
                case "up":
                    if (indexRow - 1 >= 0) {
                        matrix[indexRow][indexCol] = "-";
                        indexRow -= 1;
                        if (matrix[indexRow][indexCol].equals("X")) {
                            matrix[indexRow][indexCol] = "S";
                        } else if (matrix[indexRow][indexCol].equals("V")) {
                            matrix[indexRow][indexCol] = "S";
                            niceKidCount--;
                            countGiftReceive++;
                            countGift--;
                            if (outOfPresentsCheck(countGift, matrix, niceKidCount, countGiftReceive, saveNum)) {
                                return;
                            }
                        } else if (matrix[indexRow][indexCol].equals("C")) {
                            int savePositionSantaRow = indexRow;
                            int savePositionSantaCol = indexCol;
                            matrix[indexRow][indexCol] = "S";
                            CookieCheck cookieCheck = new CookieCheck(countGift, sizeMatrix, matrix, indexRow, indexCol,
                                    niceKidCount, countGiftReceive, savePositionSantaRow, savePositionSantaCol).invoke();
                            if (cookieCheck.is())
                                return;
                            countGift = cookieCheck.getCountGift();
                            niceKidCount = cookieCheck.getNiceKidCount();
                            countGiftReceive = cookieCheck.getCountGiftReceive();
                            if (outOfPresentsCheck(countGift, matrix, niceKidCount, countGiftReceive, saveNum)) {
                                return;
                            }
                        } else if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "S";
                        }
                    } else {
                        System.out.println("Santa ran out of presents!");
                        toPrint(matrix);
                        if (niceKidCount <= 0) {
                            System.out.printf("Good job, Santa! %d happy nice kid/s.", countGiftReceive - niceKidCount);
                        } else {
                            System.out.printf("No presents for %d nice kid/s.", niceKidCount);
                        }
                        return;
                    }
                    break;
                case "down":
                    if (indexRow + 1 < sizeMatrix) {
                        matrix[indexRow][indexCol] = "-";
                        indexRow += 1;
                        if (matrix[indexRow][indexCol].equals("X")) {
                            matrix[indexRow][indexCol] = "S";
                        } else if (matrix[indexRow][indexCol].equals("V")) {
                            matrix[indexRow][indexCol] = "S";
                            niceKidCount--;
                            countGiftReceive++;
                            countGift--;
                            if (outOfPresentsCheck(countGift, matrix, niceKidCount, countGiftReceive, saveNum)) {
                                return;
                            }
                        } else if (matrix[indexRow][indexCol].equals("C")) {
                            int savePositionSantaRow = indexRow;
                            int savePositionSantaCol = indexCol;
                            matrix[indexRow][indexCol] = "S";
                            CookieCheck cookieCheck = new CookieCheck(countGift, sizeMatrix, matrix, indexRow, indexCol,
                                    niceKidCount, countGiftReceive, savePositionSantaRow, savePositionSantaCol).invoke();
                            if (cookieCheck.is())
                                return;
                            countGift = cookieCheck.getCountGift();
                            niceKidCount = cookieCheck.getNiceKidCount();
                            countGiftReceive = cookieCheck.getCountGiftReceive();
                            if (outOfPresentsCheck(countGift, matrix, niceKidCount, countGiftReceive, saveNum)) {
                                return;
                            }

                        } else if (matrix[indexRow][indexCol].equals("-")) {
                            matrix[indexRow][indexCol] = "S";
                        }
                    } else {
                        System.out.println("Santa ran out of presents!");
                        toPrint(matrix);
                        if (niceKidCount <= 0) {
                            System.out.printf("Good job, Santa! %d happy nice kid/s.", countGiftReceive - niceKidCount);
                        } else {
                            System.out.printf("No presents for %d nice kid/s.", niceKidCount);
                        }
                        return;
                    }
                    break;
            }
            typeOfCommand = scanner.nextLine();
        }
        toPrint(matrix);
        if (niceKidCount <= 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", countGiftReceive - niceKidCount);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKidCount);
        }

    }

    private static boolean outOfPresentsCheck(int countGift, String[][] matrix, int niceKidCount, int countGiftReceive, int saveNum) {
        if (countGift <= 0) {
            System.out.println("Santa ran out of presents!");
            toPrint(matrix);
            if (niceKidCount <= 0) {
                System.out.printf("Good job, Santa! %d happy nice kid/s.", countGiftReceive - niceKidCount);
            } else {
                System.out.printf("No presents for %d nice kid/s.", niceKidCount);
            }
            return true;
        }
        return false;
    }

    private static void toPrint(String[][] matrix) {
        for (int rowToPrint = 0; rowToPrint < matrix.length; rowToPrint++) {
            for (int colToPrint = 0; colToPrint < matrix[rowToPrint].length; colToPrint++) {
                System.out.print(matrix[rowToPrint][colToPrint] + " ");
            }
            System.out.println();
        }
    }

    private static class CookieCheck {
        private boolean myResult;
        private int countGift;
        private int sizeMatrix;
        private String[][] matrix;
        private int indexRow;
        private int indexCol;
        private int niceKidCount;
        private int countGiftReceive;
        private int savePositionSantaRow;
        private int savePositionSantaCol;

        public CookieCheck(int countGift, int sizeMatrix, String[][] matrix, int indexRow, int indexCol, int niceKidCount, int countGiftReceive, int savePositionSantaRow, int savePositionSantaCol) {
            this.countGift = countGift;
            this.sizeMatrix = sizeMatrix;
            this.matrix = matrix;
            this.indexRow = indexRow;
            this.indexCol = indexCol;
            this.niceKidCount = niceKidCount;
            this.countGiftReceive = countGiftReceive;
            this.savePositionSantaRow = savePositionSantaRow;
            this.savePositionSantaCol = savePositionSantaCol;
        }

        boolean is() {
            return myResult;
        }

        public int getCountGift() {
            return countGift;
        }

        public int getNiceKidCount() {
            return niceKidCount;
        }

        public int getCountGiftReceive() {
            return countGiftReceive;
        }

        public CookieCheck invoke() {
            if (indexRow - 1 >= 0) {
                indexRow -= 1;
                if (matrix[indexRow][indexCol].equals("V")) {
                    matrix[indexRow][indexCol] = "-";
                    niceKidCount--;
                    countGiftReceive++;
                    countGift--;
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                } else if (matrix[indexRow][indexCol].equals("X")) {
                    matrix[indexRow][indexCol] = "-";
                    countGift--;
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                } else if (matrix[indexRow][indexCol].equals("-")) {
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                }
            }
            if (indexRow + 1 < sizeMatrix) {
                indexRow += 1;
                if (matrix[indexRow][indexCol].equals("V")) {
                    matrix[indexRow][indexCol] = "-";
                    niceKidCount--;
                    countGiftReceive++;
                    countGift--;
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                } else if (matrix[indexRow][indexCol].equals("X")) {
                    matrix[indexRow][indexCol] = "-";
                    countGift--;
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                } else if (matrix[indexRow][indexCol].equals("-")) {
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                }
            }
            if (indexCol + 1 < sizeMatrix) {
                indexCol += 1;
                if (matrix[indexRow][indexCol].equals("V")) {
                    matrix[indexRow][indexCol] = "-";
                    niceKidCount--;
                    countGiftReceive++;
                    countGift--;
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                } else if (matrix[indexRow][indexCol].equals("X")) {
                    matrix[indexRow][indexCol] = "-";
                    countGift--;
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                } else if (matrix[indexRow][indexCol].equals("-")) {
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                }
            }
            if (indexCol - 1 >= 0) {
                indexCol -= 1;
                if (matrix[indexRow][indexCol].equals("V")) {
                    matrix[indexRow][indexCol] = "-";
                    niceKidCount--;
                    countGiftReceive++;
                    countGift--;
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                } else if (matrix[indexRow][indexCol].equals("X")) {
                    matrix[indexRow][indexCol] = "-";
                    countGift--;
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                } else if (matrix[indexRow][indexCol].equals("-")) {
                    indexRow = savePositionSantaRow;
                    indexCol = savePositionSantaCol;
                    matrix[indexRow][indexCol] = "S";
                }
            }
            myResult = false;
            return this;
        }
    }
}
