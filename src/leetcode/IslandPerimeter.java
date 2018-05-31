/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
       
       if(grid == null || grid.length == 0){
           return 0;
       }
       int perimeter = 0;
       int rows  = grid.length;
       int cols = grid[0].length;
       
       for(int i=0;i<rows;i++){
           for(int j=0;j<cols;j++){
               if(grid[i][j] == 1){
                   perimeter += countNeigborZeroes(i,j, grid);
               }
           }
       }
       return perimeter;
    }
    
    int countNeigborZeroes(int i , int j, int [][] grid){
        int count = 0;
        if(i-1 < 0 || grid[i-1][j] == 0){
            count++;
        }
        
        if(j-1 < 0 || grid[i][j-1] == 0){
            count++;
        }
        
        if(i+1 >= grid.length || grid[i+1][j] == 0){
            count++;
        }
        
        if(j+1 >= grid[0].length || grid[i][j+1] == 0){
            count++;
        }
        
        return count;
        
    }
    
    
    public static void main(String[] args) {
        int [][] matrix = {{0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}};
        
        IslandPerimeter i = new IslandPerimeter();
        System.out.println(i.islandPerimeter(matrix));
    }
}
