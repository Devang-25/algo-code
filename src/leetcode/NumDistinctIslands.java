/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mns
 */
public class NumDistinctIslands {
    
    class ArrayListWrapper {
        ArrayList<Integer> arrayList;

        public ArrayListWrapper(ArrayList<Integer> list) {
            arrayList = list;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof ArrayListWrapper){
                return isEqual(arrayList, ((ArrayListWrapper)obj).arrayList);
            }
            return false;
        } 
        
        
    }
    
    public int numDistinctIslands(int [][] grid){
     
        if(grid== null || grid.length == 0){
            return 0;
        }
 
        ArrayList<ArrayList<Integer> > islands = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
              if(grid[i][j] == 1){
                  ArrayList<Integer> island = new ArrayList<>();
                  traverse(grid,i,j,island);
                  islands.add(island);
              }
            }
        }
        
        //System.out.println("The number of islands is " + islands.size());
        
        if(islands.isEmpty() || islands.size() == 1){
            return islands.size();
        }
        
        ArrayList<ArrayListWrapper> islandsWrapper = new ArrayList<>();
        for(int i=0;i<islands.size();i++){
            islandsWrapper.add(new ArrayListWrapper(islands.get(i)));
        }
        
        Set<ArrayListWrapper> distinctIslands = new HashSet< >(islandsWrapper);
        return distinctIslands.size();
    }
    
    private boolean isEqual(ArrayList<Integer> island1 , ArrayList<Integer> island2){
        if(island1.size() != island2.size()){ 
            return false;
        }
        
        int alignDiff= island1.get(0) - island2.get(0);
        for(int i=0;i<island1.size();i++){
            if(island1.get(i) != island2.get(i)+ alignDiff){
                return false;
            }
        }
        
        
        return true;
    }
    
    public void traverse(int [][] grid, int x, int y, ArrayList<Integer> island){
        if(x <0 || y< 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1){
            return;
        }
        
        island.add(x*grid[0].length + y);
        
        // value of -1 means it is visited
        grid[x][y] = -1;
        traverse(grid,x+1,y,island);
        traverse(grid,x,y+1,island);
        traverse(grid,x-1,y,island);
        traverse(grid,x,y-1,island);
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
