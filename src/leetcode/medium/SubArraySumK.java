package leetcode.medium;

import java.util.HashMap;

public class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int runningSum = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            runningSum += nums[i];
            if(preSum.get(runningSum-k) != null){
                result += preSum.get(runningSum-k);
            }
            preSum.put(runningSum, preSum.getOrDefault(runningSum,0)+1);
        }

        return result;
    }

    public static void main(String[] args) {
        SubArraySumK sm = new SubArraySumK();
        System.out.println(sm.subarraySum(new int[]{1,1,1},2));
    }
}
