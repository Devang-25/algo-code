import java.util.Arrays;

public class LIS {
    public int lengthOfLCS(int[] nums) {
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
                            }
                        }
                    }
                    j--;
                }
            }

            return max;

        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        LIS l = new LIS();
        System.out.println(l.lengthOfLCS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(l.lengthOfLCS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(l.lengthOfLCS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
