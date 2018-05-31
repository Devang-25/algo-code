/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.Arrays;

/**
 *
 * @author sekha
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] arr = new int[]{0};
        mz.moveZeroes(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
