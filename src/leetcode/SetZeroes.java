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
public class SetZeroes {
    
    public void setZeroes(int [][] matrix){
        if(matrix == null || matrix.length == 0){
            return;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){                
                if(matrix[i][j] == 0){
                    if(i == 0 ){
                        firstRow = true ;
                    }
                    if(j == 0){
                        firstCol = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i=1;i<rows;i++){
            if(matrix[i][0] == 0){
                for(int j=1;j<cols;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=1;j<cols;j++){
            if(matrix[0][j] == 0){
                for(int i=1;i<rows;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstRow){
            for(int j=0;j<cols;j++){
                matrix[0][j] = 0;
            }
        }
        if(firstCol){
            for(int i=0;i<rows;i++){
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        SetZeroes s = new SetZeroes();
        int [][] matrix = new int[][]{
            {1,1,1,1,1,1,1},
            {1,1,1,0,1,1,1},
            {1,0,0,1,0,1,1},
            {1,1,0,1,0,1,1},
            {1,0,1,0,1,1,1}
        };

        s.setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
