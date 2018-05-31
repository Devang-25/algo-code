/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author mns
 */
public class MergeMPlusN {

    public static final Integer NA = null;

    public static void solve(Integer[] mplusn, Integer[] N) {
        int n = N.length;
        int m = mplusn.length - n;
        int count = 0;
        int i = mplusn.length - 1;
        while (count < m) {
            if (mplusn[i] != null) {
                mplusn[mplusn.length - count - 1] = mplusn[i];
                count++;
            }
            i--;
        }

        System.out.println(Arrays.toString(mplusn));
        int ind = 0;
        int mplusnInd = n;
        int Nind = 0;

        while (Nind < n && mplusnInd < m + n) {
            if (N[Nind] < mplusn[mplusnInd]) {
                mplusn[ind] = N[Nind];
                Nind++;
            } else {
                mplusn[ind] =  mplusn[mplusnInd];
                mplusnInd++;
            }
            ind++;
        }
    }

    public static void main(String[] args) {
        Integer mPlusN[] = {2, 8, NA, NA, NA, 13, NA, 15, 20};
        Integer N[] = {5, 7, 9, 25};
        solve(mPlusN, N);
        System.out.println(Arrays.toString(mPlusN));
    }
}
