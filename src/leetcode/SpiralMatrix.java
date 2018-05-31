/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mns
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        if (matrix.length > 0) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int rowBegin = 0, colBegin = 0, rowEnd = rows - 1, colEnd = cols - 1;

            while (true) {

                for (int j = colBegin; j <= colEnd; j++) {
                    list.add(matrix[rowBegin][j]);
                }
                rowBegin++;

                for (int i = rowBegin; i <= rowEnd; i++) {
                    list.add(matrix[i][colEnd]);
                }
                colEnd--;
                
                if(rowBegin <= rowEnd){
                    for (int j = colEnd; j >= colBegin; j--) {
                        list.add(matrix[rowEnd][j]);
                    }
                    rowEnd--;
                }

                if(colBegin <= colEnd){
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        list.add(matrix[i][colBegin]);
                    }
                    colBegin++;
                }

                if (colBegin > colEnd || rowBegin > rowEnd) {
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
//        System.out.println(Arrays.toString(sm.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toArray()));
//        System.out.println(Arrays.toString(sm.spiralOrder(new int[][]{{3}, {2}}).toArray()));
        System.out.println(Arrays.toString(sm.spiralOrder(new int[][]{{2,3}}).toArray()));
    }

}
