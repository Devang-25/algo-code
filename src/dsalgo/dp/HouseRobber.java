package dsalgo.dp;

public class HouseRobber {
    public int rob2(int [] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        if(dp.length > 1){
            dp[1] = Math.max(dp[0],nums[1]);
        }
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }

        return dp[nums.length-1];
    }

    public int rob(int [] nums){
        if(nums == null || nums.length ==0 ){
            return 0;
        }

        /** exc -> last number not included ,
         * inc -> best until last number*/
        int inc = 0, exc = 0;

        for(int i=0;i<nums.length;i++){
            int temp = Math.max(inc , exc + nums[i]);
            exc = inc;
            inc = temp;
        }

        return Math.max(inc,exc);

    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(new int[]{2,7,9,3,1}));
        System.out.println(hr.rob(new int[]{1,2,3,1}));
        System.out.println(hr.rob(new int[]{2,1,1,2}));

    }
}
