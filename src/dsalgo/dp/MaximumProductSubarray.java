package dsalgo.dp;

public class MaximumProductSubarray {
    public int maxProduct (int  [] nums){
        if(nums == null || nums.length ==0){
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        int gmax = Math.max(min,max);
        for(int i=1;i<nums.length;i++){

            if(nums[i] < 0){
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            gmax = Math.max(gmax,max);
        }

        return gmax;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        System.out.println(mps.maxProduct(new int[]{2,3,-2,4}));
    }

}
