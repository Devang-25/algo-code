package dsalgo.dp;

import util.helper.Print;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length ==0){
            return false;
        }

        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        if(sum%2 != 0){
            return false;
        }
        sum/=2;

        boolean [][] dp = new boolean[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j] = dp[i-1][j];
                if(j - nums[i-1] >=0){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
            if(dp[i][sum]){
                return true;
            }
        }

        return dp[nums.length-1][sum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum ps = new PartitionEqualSubsetSum();
        System.out.println(ps.canPartition(new int[]{1,5,11}));
    }
}
