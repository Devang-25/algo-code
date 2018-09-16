package leetcode.easy;

import java.util.HashSet;

public class FairCandySwap {

    public int[] fairCandySwap(int[] a, int[] b) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
            sum += a[i];
        }
        for (int i = 0; i < b.length; i++) {
            sum -= b[i];
        }

        for (int i = 0; i < b.length; i++) {
            if (set.contains(b[i] + (sum / 2))) {
                return new int[]{b[i] + (sum / 2), b[i]};
            }
        }
        return new int[]{};
    }

}
