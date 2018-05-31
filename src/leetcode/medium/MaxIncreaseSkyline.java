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
public class MaxIncreaseSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int [] rowMax = new int [grid.length];
        int [] colMax = new int [grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            rowMax[i] = Integer.MIN_VALUE;
            for(int j=0;j<grid[0].length;j++){
                rowMax[i] = Math.max(rowMax[i],grid[i][j]); 
            }
            
        }
        
        for(int j=0;j<grid[0].length;j++){
            colMax[j] = Integer.MIN_VALUE;
            for(int i=0;i<grid.length;i++){
                colMax[j] = Math.max(colMax[j],grid[i][j]); 
            }
        }
        
        int increase = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                increase += Math.abs(Math.min(colMax[j], rowMax[i]) - grid[i][j]);
            }
            
        }
        
        return increase;
       
    }
    
    public static void main(String[] args) {
        MaxIncreaseSkyline ms = new MaxIncreaseSkyline();
        System.out.println(ms.maxIncreaseKeepingSkyline(new int [][] {
            {3, 0, 8, 4}, 
            {2, 4, 5, 7},
            {9, 2, 6, 3},
            {0, 3, 1, 0}
        }));
    }
}
