/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class Search2DMatrix2 {
     public boolean searchMatrix(int[][] matrix, int target) {
         if(matrix.length ==0 || matrix[0].length == 0)
             return false;
         
         int m=matrix.length, n=matrix[0].length, i=0, j=n-1;
         while(i<m && j>=0){
             if(matrix[i][j] == target){
                 return true;
             }else if(target > matrix[i][j]){
                 i++;
             }else{
                 j--;
             }
         }
         return false;
    }
     
     public static void main(String[] args) {
        Search2DMatrix2 s = new Search2DMatrix2();
        System.out.println(s.searchMatrix(new int[][]{
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        }, 21));
    }
}
