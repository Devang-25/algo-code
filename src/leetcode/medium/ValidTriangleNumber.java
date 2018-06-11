package leetcode.medium;


import java.util.Arrays;
import java.util.Comparator;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return 0;
        }

        int result = 0;
        for (int i = nums.length-1; i >=2 ; i--) {
            int j = i - 1, k = 0;
            while (j > k) {
                if (nums[j] + nums[k] > nums[i]) {
                    result += (j - k);
                    j--;
                } else {
                    k++;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        ValidTriangleNumber vn = new ValidTriangleNumber();
        System.out.println(vn.triangleNumber(new int[]{2, 2, 3, 4}));
    }
}
