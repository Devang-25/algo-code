package leetcode.medium;

import java.util.Arrays;

public class T3SumSmall {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        if(nums.length < 3){
            return result;
        }

        for(int i=0;i<nums.length-2;i++){
            int j = i+1, k = nums.length-1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] < target){
                    result += (k-j);
                    j++;
                }else{
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        T3SumSmall ts = new T3SumSmall();
        System.out.println(ts.threeSumSmaller(new int [] {-2,0,1,3} , 2));
    }
}
