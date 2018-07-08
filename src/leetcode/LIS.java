package leetcode;
import java.util.Arrays;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        if (nums != null && nums.length > 0) {

            int[] maxLengthEndingHere = new int[nums.length];
            Arrays.fill(maxLengthEndingHere, 1);
            int max = 1;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]){
                        maxLengthEndingHere[i] = Math.max(maxLengthEndingHere[i] , 1+maxLengthEndingHere[j]);
                        max = Math.max(maxLengthEndingHere[i],max);
                    }
                }
            }
            return max;
        }
        return 0;
    }


    public static void main(String[] args) {
        LIS l = new LIS();
        System.out.println(l.lengthOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(l.lengthOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
