package leetcode;

import java.util.Arrays;

public class LISTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums != null && nums.length > 0) {

            int[] maxLengthEndingHere = new int[nums.length];

            Arrays.fill(maxLengthEndingHere, 1);

            int max = 1;

            for (int i = 1; i < nums.length; i++) {
                int j = i - 1;
                while (j >= 0) {
                    if (nums[i] > nums[j]) {
                        if (maxLengthEndingHere[j] + 1 > maxLengthEndingHere[i]) {
                            maxLengthEndingHere[i] = maxLengthEndingHere[j] + 1;

                            if (maxLengthEndingHere[i] > max) {
                                max = maxLengthEndingHere[i];
                                if(max == 3){
                                    return true;
                                }
                            }
                        }
                    }
                    j--;
                }
            }

            return false;

        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        LISTriplet l = new LISTriplet();
        System.out.println(l.increasingTriplet(new int[]{1, 3, 5, 4, 7}));
        System.out.println(l.increasingTriplet(new int[]{2, 2, 2, 2, 2}));
        System.out.println(l.increasingTriplet(new int[]{10,9,2,5,3,7,101,18}));
    }
}
