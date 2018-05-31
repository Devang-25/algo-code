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
public class NumIslands {
    
    public int numIslands( char [][] grid){
        int numIslands = 0;
        int rows = grid.length;
        
        if(rows > 0){
            int cols = grid[0].length;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid[i][j] == '1'){
                        traverse(grid, i, j);
                        numIslands++;
                    }
                }
            }
        }
        
        return numIslands;
        
    }
    
    public void traverse( char[][] grid, int x, int y){
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0 )
            return;
        
        
        if(grid[x][y] == '1'){
            // Marking it as visited
            grid[x][y] = 'x';
            traverse(grid, x+1,y);
            traverse(grid,x,y+1);
            traverse(grid,x-1,y);
            traverse(grid,x,y-1);
        }
        
    }
    
    public static void main(String[] args) {
        NumIslands nis = new NumIslands();
        char [][] grid = {
                            {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'},
                         };
        char [][] grid2 = {
                            {'1','1','0','0','0'},
                            {'1','1','0','0','0'},
                            {'0','0','1','0','0'},
                            {'0','0','0','1','1'},
                         };
        char [][] grid3 = {
                            {'1','1','0','0','1'},
                            {'1','1','0','0','0'},
                            {'0','0','1','1','0'},
                            {'1','0','1','1','1'},
                         };
        char [][] grid4 = {
                            {'0'}
                         };
        
        System.out.println(nis.numIslands(new char [][]{}));
        System.out.println(nis.numIslands(grid));
        System.out.println(nis.numIslands(grid2));
        System.out.println(nis.numIslands(grid3));
        System.out.println(nis.numIslands(grid4));
    }
}
