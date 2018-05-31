/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Random;

/**
 *
 * @author sekha
 */
public class KthSmallestLex {

    class LexNumbers implements Comparable {

        int val;

        public LexNumbers(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.toString(this.val).compareTo(Integer.toString(((LexNumbers)o).val));
        }

    }

    public int findKthNumber(int n, int k) {
        LexNumbers[] arr = new LexNumbers[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = new LexNumbers(i);
        }

        return select(arr, k-1).val;
    }

    private int partition(LexNumbers[] arr, int left, int right, int pivot) {
        LexNumbers pivotVal = arr[pivot];
        swap(arr, pivot, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i].compareTo(pivotVal) < 0) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex);
        return storeIndex;
    }

    private LexNumbers select(LexNumbers[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        Random rand = new Random();
        while (right >= left) {
            int pivotIndex = partition(arr, left, right, rand.nextInt(right - left + 1) + left);
            if (pivotIndex == n) {
                return arr[pivotIndex];
            } else if (pivotIndex < n) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return null;
    }

    private static void swap(Object[] arr, int i1, int i2) {
        if (i1 != i2) {
            Object temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
        }
    }

    public static void main(String[] args) {
        KthSmallestLex k = new KthSmallestLex();
        System.out.println(k.findKthNumber(100, 3));
    }
}
