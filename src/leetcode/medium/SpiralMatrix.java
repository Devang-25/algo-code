package leetcode.medium;

/**
 * Created by mns on 12/27/18.
 */
public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int [][] result = new int[n][n];
        int left = 0, right = n-1, bottom = n-1, top = 0;
        int num = 1;

        while( num <= n*n){
            int i,j;

            j = left;
            while(j <= right){
                result[top][j++] = num++;
            }
            top++;

            i = top;
            while( i <= bottom){
                result[i++][right] = num++;
            }
            right--;

            j=right;
            while(j >= left){
                result[bottom][j--] = num++;
            }
            bottom--;

            i = bottom;
            while( i >= top){
                result[i--][left] = num++;
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        s.generateMatrix(5);
        System.out.println("debug");
    }
}
