/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author sekha
 */
public class Toeplitz {
    public boolean isToeplitzMatrix(int[][] matrix) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(!map.containsKey(i-j)){
                    map.put(i-j,matrix[i][j]);
                }else{
                    if(map.get(i-j) != matrix[i][j]){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Toeplitz t = new Toeplitz();
        System.out.println(t.isToeplitzMatrix(new int[][] {{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
    }
}
