/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sekha
 */
public class NumbersDisappeared {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<Integer>();

        int index = 0;
        while (index < nums.length) {
            if (nums[index] < 1 || nums[index] > nums.length) {
                index++;
            } else {
                if (nums[index] - 1 <= index) {
                    nums[nums[index] - 1] = Integer.MIN_VALUE;
                    index++;
                } else {
                    int num = nums[nums[index] - 1];
                    if(num == Integer.MIN_VALUE){
                        index++;
                    }else{
                        nums[nums[index] - 1] = Integer.MIN_VALUE;
                        nums[index] = num;
                    }
                    
                }
            }
        }

        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                output.add(i + 1);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        NumbersDisappeared nd = new NumbersDisappeared();
//        int[] a = {1, 1, 2, 4, 5, 6, 7};
//        int [] a = {4,3,2,7,8,2,3,1};
        int [] a = {2,2};
        List<Integer> list = nd.findDisappearedNumbers(a);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
