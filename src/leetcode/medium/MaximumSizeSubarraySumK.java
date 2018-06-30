package leetcode.medium;


import java.util.HashMap;

public class MaximumSizeSubarraySumK {
    public int maxSubArrayLen2(int[] nums, int k) {
        int  [] presum = new int [nums.length+1];
        presum[0] = 0;
        int maxLength = 0;
        for(int i=1;i<=nums.length;i++){
            presum[i] = nums[i-1]+presum[i-1];
        }

        for(int i=0;i<=nums.length;i++){
            for(int j=i+1;j<=nums.length;j++){
                if(presum[j] - presum[i] == k){
                    maxLength = Math.max(maxLength,j-i);
                }
            }
        }

        return maxLength;
    }

    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum == k){
                maxLength = Math.max(maxLength, i+1);
            }else{
                if(map.get(k-sum) != null){
                    maxLength = Math.max(maxLength,i-map.get(k-sum)+1);
                }
            }

            map.putIfAbsent(sum,i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        MaximumSizeSubarraySumK ms = new MaximumSizeSubarraySumK();
        System.out.println(ms.maxSubArrayLen(new int[]{1,-1,5,-2,3},3));
    }
}
