/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashSet;
/**
 *
 * @author mns
 */
public class NumDistinctIslands {

    public int numDistinctIslands(int [][] grid){
     
        if(grid== null || grid.length == 0){
            return 0;
        }

        HashSet<String> set = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
              if(grid[i][j] == 1){
                  StringBuilder sb = new StringBuilder();
                  traverse(grid,i,j,0,0,sb);
                  set.add(sb.toString());
              }
            }
        }

        return set.size();
    }

    
    public void traverse(int [][] grid, int x, int y, int x1, int y1, StringBuilder sb){
        if(x <0 || y< 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1){
            return;
        }

        sb.append(x1).append(",").append(y1);
        
        // value of -1 means it is visited
        grid[x][y] = -1;
        traverse(grid,x+1,y,x1+1,y1,sb);
        traverse(grid,x,y+1,x1,y1+1,sb);
        traverse(grid,x-1,y,x1-1,y1,sb);
        traverse(grid,x,y-1,x1,y1-1,sb);
    }
    
    public static void main(String[] args) {
        NumDistinctIslands nis = new NumDistinctIslands();
        int [][] grid = {
                            {1,1,1,1,0},
                            {1,1,0,1,0},
                            {1,1,0,0,0},
                            {0,0,0,0,0},
                         };
        int [][] grid2 = {
                            {1,1,0,0,0},
                            {1,1,0,0,0},
                            {0,0,1,0,0},
                            {0,0,0,1,1},
                         };
        int [][] grid3 = {
                            {1,1,0,0,1},
                            {1,1,0,0,0},
                            {0,0,1,1,0},
                            {1,0,1,1,1},
                         };
        int [][] grid4 = {
                            {1}
                         };
        int [][] grid5 = {
                            {0,1,1},
                            {1,1,1},
                            {0,0,0},
                            {1,1,1},
                            {1,1,0}
                         };
        
        System.out.println(nis.numDistinctIslands(grid));
        System.out.println(nis.numDistinctIslands(grid2));
        System.out.println(nis.numDistinctIslands(grid3));
        System.out.println(nis.numDistinctIslands(grid4));
        System.out.println(nis.numDistinctIslands(grid5));
    }
}
