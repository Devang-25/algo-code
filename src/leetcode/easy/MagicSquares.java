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
public class MagicSquares {
    public int numMagicSquaresInside(int [][] grid){
        if(grid == null || grid.length < 3 || grid[0].length < 3){
            return 0;
        }
        
        int result = 0;
        
        for(int i=0;i<=grid.length-3;i++){
            for(int j=0;j<=grid[0].length-3;j++){
                //System.out.println(i + " " + j);
                if(isMagical(i,j,grid)){
                    result++ ;
                }
            }
        }
        return result;
    }
    
    private boolean isMagical(int i, int j, int [][] grid){
        int [] rowSum = new int[3];
        int [] colSum = new int[3];
        int [] diagSum = new int[2];
        
        for(int x = 0;x <3;x++){
            for(int y = 0; y<3;y++){
                if(grid[x+i][y+j] < 1 || grid[x+i][y+j] >9)
                    return false;
                
                rowSum[x]+= grid[x+i][y+j];
                colSum[y]+= grid[x+i][y+j];
                if(x == y){
                    diagSum[0] += grid[x+i][y+j];
                }
                if( x+y == 2){
                    diagSum[1] += grid[x+i][y+j];
                }
            }
        }
        
        if(diagSum[0] != diagSum[1]){
            return false;
        }
        
        for(int ii=0;ii<3;ii++){
            if(rowSum[ii] != diagSum[0] || colSum[ii] != diagSum[0]){
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        MagicSquares ms =  new MagicSquares();
        System.out.println(ms.numMagicSquaresInside(new int[][]{
            {4,3,8,4},
            {9,5,1,9},
            {2,7,6,2},
        }));
        System.out.println(ms.numMagicSquaresInside(new int[][]{
            {10,3,5},
            {1,6,11},
            {7,9,2},
        }));
    }
}
