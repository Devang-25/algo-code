package medium;

import java.util.Arrays;

/**
 * Created by mns on 6/26/18.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        if(nums == null || nums.length == 0){
            return result;
        }

        result[0] = 1;
        for(int i=1;i<nums.length;i++){
            result[i] = result[i-1]*nums[i-1];
        }

        int sumToRight = 1;
        for(int i=result.length-1;i>=0;i--){
            result[i] = result[i]*sumToRight;
            sumToRight *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
       ProductOfArrayExceptSelf ps = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(ps.productExceptSelf(new int[] {1,2,3,4})));
    }
}
