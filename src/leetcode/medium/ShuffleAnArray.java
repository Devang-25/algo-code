package leetcode.medium;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int [] orig = null;
    private int [] shuffled = null;
    Random r = new Random();
    public ShuffleAnArray(int[] nums) {
        this.shuffled = Arrays.copyOf(nums,nums.length);
        this.orig = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.orig;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
         for(int i=0;i<orig.length;i++){
             int randIndex = r.nextInt(orig.length);
             int temp = shuffled[randIndex];
             shuffled[randIndex] = shuffled[i];
             shuffled[i] = temp;
         }
         return shuffled;
    }

    public static void main(String[] args) {
        ShuffleAnArray sf = new ShuffleAnArray(new int[]{1,2,3,4,5,6});
        System.out.println(Arrays.toString(sf.shuffle()));
        System.out.println(Arrays.toString(sf.reset()));
    }

}
