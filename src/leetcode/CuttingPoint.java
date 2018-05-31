/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mns
 */
public class CuttingPoint {

    public static int findIndex(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            boolean leftok = true;
            boolean rightok = true;
            int pivot = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < pivot) {
                    rightok = false;
                    break;
                }
            }

            if (!rightok) {
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (arr[j] > pivot) {
                    leftok = false;
                    break;
                }
            }

            if (!leftok) {
                continue;
            }

            if (leftok && rightok && i != 0 && i != arr.length - 1) {
                return i;
            }
        }

        return index;
    }

    public static int findIndexOpt(int[] arr) {

        if (arr != null && arr.length == 0) {
            return -1;
        }

        int index = -1;

        int[] maxSoFar = new int[arr.length];
        Arrays.fill(maxSoFar, Integer.MIN_VALUE);
        maxSoFar[0] = arr[0];

        int[] minAfter = new int[arr.length];
        Arrays.fill(minAfter, Integer.MAX_VALUE);
        minAfter[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            if (maxSoFar[i - 1] < arr[i]) {
                maxSoFar[i] = arr[i];
            } else {
                maxSoFar[i] = maxSoFar[i - 1];
            }
        }

        System.out.println(Arrays.toString(maxSoFar));
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < minAfter[i + 1]) {
                minAfter[i] = arr[i];
            } else {
                minAfter[i] = minAfter[i + 1];
            }
        }
        System.out.println(Arrays.toString(minAfter));

        for (int i = 1; i < arr.length-1; i++) {
            if (minAfter[i+1] > arr[i] && maxSoFar[i-1] < arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findIndex(arr));
        System.out.println(findIndexOpt(arr));
        
        //1 5 4 6 7 8 10 11 9 19
        
    }
}
