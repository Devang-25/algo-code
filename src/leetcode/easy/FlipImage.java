/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

/**
 *
 * @author sekha
 */
public class FlipImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int m  = A.length;
        int n = A[0].length;
       
        int [][] newA = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=n-1,k=0;j>=0;j--,k++){
                newA[i][k] = A[i][j] == 1?0:1;
            }
        }
        
        return newA;
    }
    
    public static void main(String[] args) {
        FlipImage fi = new FlipImage();
        int [][] result = fi.flipAndInvertImage(new int [][] {{1,1,0},{1,0,1},{0,0,0}});
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]);
            }
            System.out.println("");
        }
    }
}
