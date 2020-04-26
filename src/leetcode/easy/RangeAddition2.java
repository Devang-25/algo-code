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
public class RangeAddition2 {
    public int maxCount(int m, int n, int[][] ops) {
        int x= m; int y=n;
        for(int i=0;i<ops.length;i++){
            x = Math.min(x,ops[i][0]);
            y = Math.min(y, ops[i][1]);
        }
        
        return x*y;
    }
    
    public static void main(String[] args) {
        RangeAddition2 ra = new RangeAddition2();
        System.out.println(ra.maxCount(3,3,new int[][]{
            {2,2},
            {3,3},{0,0}
        }));
    }
}
