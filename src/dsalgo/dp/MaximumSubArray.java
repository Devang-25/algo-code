package dsalgo.dp;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0 ){
            return 0;
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for(int i=1;i<nums.length;i++){
            maxEndingHere += nums[i];
            if(maxEndingHere < 0){
                maxEndingHere = nums[i];
            }
            maxSoFar = Math.max(maxSoFar,maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSubArray ms = new MaximumSubArray();
        System.out.println(ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(ms.maxSubArray(new int[]{-1}));
    }
}
