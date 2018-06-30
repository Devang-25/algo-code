package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mns on 6/26/18.
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {

        if(matrix==null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }

        int x = 0, y = 0;
        boolean direction = true;
        ArrayList<Integer> result = new ArrayList<>();

        while (y < matrix[0].length) {
            ArrayList<Integer> nums = traverseRTL(matrix,x,y);
            if (direction) {
                Collections.reverse(nums);
            }
            result.addAll(nums);
            direction = !direction;
            y++;
        }

        x+=1 ; y-=1;
        while (x < matrix.length) {
            ArrayList<Integer> nums = traverseRTL(matrix,x,y);
            if (direction) {
                Collections.reverse(nums);
            }
            result.addAll(nums);
            direction = !direction;
            x++;
        }

        int [] r = new int [result.size()];
        for(int i=0;i<r.length;i++){
            r[i]=result.get(i);
        }
        return r;
    }

    private ArrayList<Integer> traverseRTL(int [][] matrix, int x1,int y1){
        ArrayList<Integer> nums = new ArrayList<>();
        while (x1 < matrix.length && x1>=0 && y1 < matrix[0].length && y1 >=0) {
            nums.add(matrix[x1++][y1--]);
        }
        return nums;
    }

    public static void main(String[] args) {
        DiagonalTraverse dt = new DiagonalTraverse();
        System.out.println(Arrays.toString(dt.findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));
        System.out.println(Arrays.toString(dt.findDiagonalOrder(new int[][]{
                {1, 2, 3},
        })));
        System.out.println(Arrays.toString(dt.findDiagonalOrder(new int[][]{
                {1},
                {2},
                {3}
        })));
        System.out.println(Arrays.toString(dt.findDiagonalOrder(new int[][]{
                {1},
        })));
        System.out.println(Arrays.toString(dt.findDiagonalOrder(new int[][]{
                {}
        })));
    }
}
