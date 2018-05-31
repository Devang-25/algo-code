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
public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix == null){
            return;
        }
        
        int dimension = matrix.length;
        
        int rowBegin = 0, colBegin = 0, rowEnd = dimension-1, colEnd = dimension-1;

        while(true){
            for(int j = 0;j<(colEnd-colBegin) ;j++){
                int temp = matrix[rowBegin][colBegin+j];
                matrix[rowBegin][colBegin+j] = matrix[rowEnd-j][colBegin];
                matrix[rowEnd-j][colBegin] = matrix[rowEnd][colEnd-j];
                matrix[rowEnd][colEnd-j] = matrix[rowBegin+j][colEnd];
                matrix[rowBegin+j][colEnd] = temp;
            }
            colBegin++;
            colEnd--;
            rowBegin++;
            rowEnd--;
            
//            print(matrix);
            if(colBegin >= colEnd)
                break;
            
            
        }
    }
    
    public void print(int [][] image){
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        //int [][] image = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int [][] image = {{1,2},{3,4}};
        //int [][] image = {{1}};
        int [][] image = {
            {1,29,20,26,16,28},
            {12,27,9,25,13,21},
            {32,33,32,2,28,14},
            {13,14,32,27,22,26},
            {33,1,20,7,21,7},
            {4,24,1,6,32,34}
        };
//                int [][] image = {
//            {1,2,3,4,5,6},
//            {7,8,9,10,11,12},
//            {13,14,15,16,17,18},
//            {19,20,21,22,23,24},
//            {25,26,27,28,29,30},
//            {31,32,33,34,35,36}
//        };
        ri.rotate(image);
        
       ri.print(image);
    }
}
