package app;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = rand.nextInt(50) + 1;
            }
        }

        System.out.println("Matrix 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int sumEvenRows = 0;
        int sumOddRows = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    sumEvenRows += matrix[i][j];
                } else {
                    sumOddRows += matrix[i][j];
                }
            }
        }

        long productEvenCols = 1;
        long productOddCols = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    productEvenCols *= matrix[i][j];
                } else {
                    productOddCols *= matrix[i][j];
                }
            }
        }

        System.out.println("\nSum of elements in even rows (row 0, 2): " + sumEvenRows);
        System.out.println("Sum of elements in odd rows (row 1, 3): " + sumOddRows);
        System.out.println("Product of elements in even columns (column 0, 2): " + productEvenCols);
        System.out.println("Product of elements in odd columns (column 1, 3): " + productOddCols);

        if (isMagicSquare(matrix)) {
            System.out.println("\nThe matrix is a magic square.");
        } else {
            System.out.println("\nThe matrix is not a magic square.");
        }
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int sumDiagonal1 = 0, sumDiagonal2 = 0;
        for (int i = 0; i < 4; i++) {
            sumDiagonal1 += matrix[i][i];
            sumDiagonal2 += matrix[i][3 - i];
        }

        if (sumDiagonal1 != sumDiagonal2) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int sumRow = 0, sumCol = 0;
            for (int j = 0; j < 4; j++) {
                sumRow += matrix[i][j];
                sumCol += matrix[j][i];
            }

            if (sumRow != sumDiagonal1 || sumCol != sumDiagonal1) {
                return false;
            }
        }

        return true;
    }
}
