import java.util.*;

public class StringMatrixRotation__06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String operations = input.replaceAll("[^0-9]", "");
        int rotationAsNum = Integer.parseInt(operations);
        List<String> allElements = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("END")) {

            allElements.add(command);

            command = scanner.nextLine();
        }
        int indexOfCurrElements = 0;
        int charIndex = 0;
        int maxLen = allElements.stream().max(Comparator.comparingInt(String::length)).get().length();
        char[][] matrix = new char[allElements.size()][maxLen];
        for (int row = 0; row < allElements.size(); row++) {
            for (int col = 0; col < maxLen; col++) {
                matrix[row][col] = ' ';
            }
        }
        for (int row = 0; row < allElements.size(); row++) {
            for (int col = 0; col < allElements.get(indexOfCurrElements).length(); col++) {
                char currElements = allElements.get(indexOfCurrElements).charAt(charIndex);
                matrix[row][col] = currElements;


                charIndex++;
            }
            indexOfCurrElements++;
            charIndex = 0;
        }

        if (rotationAsNum == 0) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
            return;
        }

        int countRotationToDo = rotationAsNum / 90;
        int count = 1;
        char[][] rotedMatrix = new char[matrix[0].length][matrix.length];
        int printTime = 1;
        while (true) {
            int newRow = matrix.length;
            int newCol = matrix[0].length;

            rotedMatrix = new char[matrix[0].length][matrix.length];

            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    rotedMatrix[i][j] = matrix[j][i];
                }
            }
            printTime++;
            count++;

            if (count > countRotationToDo) {
                if (printTime == 1) {
                    char[][] reversedMatrix = new char[maxLen][allElements.size()];
                    for (int row = 0; row < rotedMatrix.length; row++) {
                        for (int col = rotedMatrix[row].length - 1; col >= 0; col--) {
                            char curr = rotedMatrix[row][col];
                            reversedMatrix[row][col] = curr;
                            System.out.print(reversedMatrix[row][col]);
                        }
                        System.out.println();
                    }
                    return;
                }
                if ((printTime / 2) % 2 == 0) {

                    char[][] reversedMatrix = new char[maxLen][allElements.size()];
                    for (int row = rotedMatrix.length - 1; row >= 0; row--) {
                        for (int col = 0; col < rotedMatrix[row].length; col++) {       // NO
                            char curr = rotedMatrix[row][col];
                            reversedMatrix[row][col] = curr;
                            System.out.print(reversedMatrix[row][col]);
                        }
                        System.out.println();
                    }
                    return;

                } else {

                    char[][] reversedMatrix = new char[maxLen][allElements.size()];
                    for (int row = 0; row < rotedMatrix.length; row++) {
                        for (int col = rotedMatrix[row].length - 1; col >= 0; col--) {
                            char curr = rotedMatrix[row][col];
                            reversedMatrix[row][col] = curr;
                            System.out.print(reversedMatrix[row][col]);
                        }
                        System.out.println();
                    }
                    return;
                }


            }
            char[][] demo = new char[allElements.size()][maxLen];
            for (int i = 0; i < allElements.size(); i++) {
                for (int j = 0; j < maxLen; j++) {
                    demo[i][j] = rotedMatrix[j][i];
                }
            }
            printTime++;
            count++;
            if (count > countRotationToDo) {
                if ((printTime / 2) % 2 == 0) {

                    char[][] reversedMatrix = new char[allElements.size()][maxLen];

                    for (int row = 0; row < demo.length; row++) {
                        for (int col = 0; col < demo[row].length; col++) {
                            char curr = demo[row][col];
                            reversedMatrix[row][col] = curr;
                            System.out.print(reversedMatrix[row][col]);
                        }
                        System.out.println();
                    }
                    return;

                } else {
                    char[][] reversedMatrix = new char[allElements.size()][maxLen];

                    for (int row = demo.length - 1; row >= 0; row--) {
                        for (int col = demo[row].length - 1; col >= 0; col--) {
                            char curr = demo[row][col];
                            reversedMatrix[row][col] = curr;
                            System.out.print(reversedMatrix[row][col]);
                        }
                        System.out.println();
                    }
                    return;
                }
            }
        }
    }
}
