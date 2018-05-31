/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int index = 0;
        int numPositives = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                numPositives++;
            }
        }

        while (index < nums.length) {
            if (nums[index] <= 0 || nums[index] > numPositives) {
                index++;
            } else if (nums[index] > 0 && nums[index] <= numPositives) {
                if (nums[index] - 1 > index) {
                    int currNum = nums[index];
                    if(nums[currNum - 1] != Integer.MIN_VALUE){
                        nums[index] = nums[nums[index] - 1];
                        nums[currNum - 1] = Integer.MIN_VALUE;
                    }else{
                        index++;
                    }
                } else {
                    nums[nums[index] - 1] = Integer.MIN_VALUE;
                    index++;
                }
            }
        }

        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                return i + 1;
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
//        int a [] = {1,2,0};
//        int a[] = {3, 4, -1, 1};
        //int a[] = {99,1,2,88,-1000};
        int a[] = {2,2};
        FirstMissingPositive fp = new FirstMissingPositive();
        System.out.println(fp.firstMissingPositive(a));
    }
}
