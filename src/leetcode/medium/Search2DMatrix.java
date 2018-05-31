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
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0,right = rows*cols-1;
        
        while(left <= right){
            int mid =left + (right-left)/2;
            if(matrix[mid/cols][mid%cols] == target){
                return true;
            }
            
            if(matrix[mid/cols][mid%cols] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix s = new Search2DMatrix();
        System.out.println(s.searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        }, 51));
    }
}
