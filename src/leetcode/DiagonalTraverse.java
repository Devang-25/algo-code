/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0) {
            int index = 0;
            int x = 0, y = 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[] result = new int[m * n];
            while (index < m * n) {
                while (valid(x, y, m, n)) {
                    result[index++] = matrix[x--][y++];
                }
                if (y == n) {
                    y = n - 1;
                    x += 2;
                } else {
                    x = x + 1;
                }

                while (valid(x, y, m, n)) {
                    result[index++] = matrix[x++][y--];
                }

                if (x == m) {
                    x = m - 1;
                    y += 2;
                } else {
                    y += 1;
                }
            }

            return result;
        }
        return new int[]{};
    }

    public boolean valid(int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        int [][] matrix = {
//            {1,2,3,4},
//            {4,5,6,7},
//            {8,9,10,11},
//            {12,13,14,15}
//        };
//        int [][] matrix = {
//            {1,2,3,4},
//            
//        };
        int[][] matrix = {
            {1,2,3,6},
            {2,3,4,6},
            {3,4,5,6},
            {4,5,6,6}
        };
        DiagonalTraverse dt = new DiagonalTraverse();
        int[] res = dt.findDiagonalOrder(matrix);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
