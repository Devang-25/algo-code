package leetcode.medium;

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        return removeDuplicatesUtil(nums,2);
    }
     private int removeDuplicatesUtil(int [] nums, int k){
        if(nums.length <=k){
            return nums.length;
        }

        int currPos = 1;
        int occur = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                if(occur < k){
                    occur++;
                    nums[currPos++] = nums[i];
                }
            }else{
                occur = 1;
                nums[currPos++] = nums[i];
            }
        }

        return currPos;
     }

    public static void main(String[] args) {
        RemoveDuplicates2 rm = new RemoveDuplicates2();
        System.out.println(rm.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        System.out.println(rm.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}
