package leetcode.medium;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int [] nums, int k){
        int result = 0, product = 1;
        int left = 0, right = 0;
        while(right < nums.length){
            product *= nums[right];
            while( left <= right && product >= k ){
                product /= nums[left];
                left++;
            }
            result += right-left+1;
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK sb = new SubarrayProductLessThanK();
        System.out.println(sb.numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
    }
}
