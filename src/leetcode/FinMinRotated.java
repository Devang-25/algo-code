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
public class FinMinRotated {

    static class Solution {

        public int getMin(int[] arr, int left, int right) {
            if (left == right) {
                return arr[left];
            }
            if ((right - left) == 1) {
                return Math.min(arr[left], arr[right]);
            }

            int middle = left + (right - left) / 2;

          
            if (arr[left] < arr[right]) {
                return arr[left];

               
            } else if (arr[middle] > arr[left]) {
                return getMin(arr, middle, right);

                
            } else {
                return getMin(arr, left, middle);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] arr = {18,19,1,12,13,14,15,16,17};
        System.out.println(s.getMin(arr, 0, arr.length - 1));

    }
}
