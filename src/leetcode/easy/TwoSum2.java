package leetcode.easy;

import java.util.Arrays;

public class TwoSum2 {
    public int[] twoSum(int[] n, int target) {
        int i =0, j = n.length-1;
        while(i!=j && i < j){
            if(n[i] + n[j] == target){
                return new int[]{i+1,j+1};
            }else if(n[i] + n[j] < target){
                i++;
            }else{
                j--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum2 ts = new TwoSum2();
        System.out.println(Arrays.toString(ts.twoSum(new int[]{
                2,7,11,15
        },9)));
    }
}
