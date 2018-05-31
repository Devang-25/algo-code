package leetcode.medium;

import java.util.Arrays;

/**
 * Created by mns on 5/9/18.
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int [] result = new int [nums.length];
        int i = 0, j = nums.length-1;
        int index = a >= 0? j: 0;

        while( i <= j){
            int val1 = quad(nums[i],a,b,c);
            int val2 = quad(nums[j],a,b,c);

            if(a >= 0){
                if(val1 > val2){
                    result[index] = val1;
                    i++;
                }else{
                    result[index] = val2;
                    j--;
                }
                index--;
            }else{
                if(val1 > val2){
                    result[index] = val2;
                    j--;
                }else{
                    result[index] = val1;
                    i++;
                }
                index++;
            }
        }

        return result;
    }

    int quad(int x,int a , int b, int c){
        return (a * x + b)*x + c;
    }


    public static void main(String[] args) {
        SortTransformedArray s = new SortTransformedArray();
        Arrays.stream(s.sortTransformedArray(new int[]{-4,-2,2,4},1,3,5)).forEach(System.out::println);
        Arrays.stream(s.sortTransformedArray(new int[]{-4,-2,2,4},-1,3,5)).forEach(System.out::println);
    }
}
