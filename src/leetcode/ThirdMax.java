/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class ThirdMax {

    public int thirdMax(int[] nums) {

        if (nums.length > 0) {
            long thirdLargest = Long.MIN_VALUE, secondLargest = Long.MIN_VALUE, firstLargest = Long.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > firstLargest) {
                    thirdLargest = secondLargest;
                    secondLargest = firstLargest;
                    firstLargest = nums[i];
                } else if (nums[i] > secondLargest && nums[i] < firstLargest) {
                    thirdLargest = secondLargest;
                    secondLargest = nums[i];
                } else if (nums[i] > thirdLargest && nums[i] < secondLargest && nums[i] < firstLargest) {
                    thirdLargest = nums[i];
                }
            }

            if (thirdLargest != Long.MIN_VALUE) {
                return (int) thirdLargest;
            }
            return (int) firstLargest;
        }

        return -1;
    }
}
