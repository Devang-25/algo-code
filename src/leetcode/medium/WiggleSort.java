package leetcode.medium;

import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(i %2 == 0 && nums[i-1] < nums[i]){
                swap(nums,i,i-1);
            }else if( i%2 == 1 && nums[i-1]>nums[i]){
                swap(nums,i,i-1);
            }
        }
    }

    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++) {
            if(i % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }

    private void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        WiggleSort ws = new WiggleSort();
        int [] nums = new int[]{3,5,2,1,6,4};
        ws.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
