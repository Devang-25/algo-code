public class LCIS {

    public int findLengthOfLCIS(int[] nums) {

        if(nums != null && nums.length > 0) {
            int maxLength = 1;
            int lengthSoFar = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    lengthSoFar++;
                    if (lengthSoFar > maxLength) {
                        maxLength = lengthSoFar;
                    }
                } else {
                    lengthSoFar = 1;
                }
            }

            return maxLength;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        LCIS l = new LCIS();
        System.out.println(l.findLengthOfLCIS(new int [] {1,3,5,4,7}));
    }
}
