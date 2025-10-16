package JAVA.SHASHCODE.LECTURE36;

import java.util.ArrayList;
import java.util.List;

public class Spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = m - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // first Row
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }
            startRow += 1;
            // end col
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol -= 1;

            if (startRow <= endRow) {
                // last Row
                for (int j = endCol; j >= startCol; j--) {
                    result.add(matrix[endRow][j]);
                }
                endRow -= 1;
            }

            if (startCol <= endCol) {
                // first col
                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
                startCol += 1;

            }
        }
        return result;
    }


    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;
        int val=1;
        while (startRow <= endRow && startCol <= endCol) {
            // first Row
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j]=val;
                val+=1;
            }
            startRow += 1;
            // end col
            for (int i = startRow; i <= endRow; i++) {
                matrix[i][endCol]=val;
                val+=1;
            }
            endCol -= 1;

            if (startRow <= endRow) {
                // last Row
                for (int j = endCol; j >= startCol; j--) {
                    matrix[endRow][j]=val;
                    val+=1; 
                }
                endRow -= 1;
            }

            if (startCol <= endCol) {
                // first col
                for (int i = endRow; i >= startRow; i--) {
                    matrix[i][startCol]=val;
                    val+=1;
                }
                startCol += 1;

            }
        }
        return matrix;
    }
}
