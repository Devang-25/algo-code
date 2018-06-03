package dsalgo.dp;

import java.util.Arrays;

public class HouseRobber2 {
    public int robUtil(int [] nums){

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

    public int rob(int[] nums) {

        if(nums == null || nums.length ==0 ){
            return 0;
        }

        if(nums.length == 1 ){
            return nums[0];
        }

       int [] nums1 = Arrays.copyOfRange(nums,0,nums.length-1);
       int [] nums2 = Arrays.copyOfRange(nums,1,nums.length);

       return Math.max(robUtil(nums1),robUtil(nums2));
    }

    public static void main(String[] args) {
        HouseRobber2 hr = new HouseRobber2();
        System.out.println(hr.rob(new int[]{2,7,9,3,1}));
        System.out.println(hr.rob(new int[]{1,2,3,1}));
        System.out.println(hr.rob(new int[]{2,1,1,2}));
        System.out.println(hr.rob(new int[]{0}));
    }
}
