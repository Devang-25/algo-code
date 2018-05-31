/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class FriendsOfAppropriateAges {

    private static final int MAX_AGE = 120;

    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }

        int[] cnt = new int[MAX_AGE + 1];
        for (int i = 0; i < ages.length; i++) {
            cnt[ages[i]] += 1;
        }

        int total = 0;
        for (int i = 1; i <= MAX_AGE; i++) {
            for (int j = 1; j <= MAX_AGE; j++) {
                if (cnt[i] > 0 && cnt[j] > 0) {
                    if (j <= 0.5 * i + 7 || j > i || (j > 100 && i < 100)) {
                        continue;
                    }

                    // System.out.println(i + " --> " + j);
                    total += cnt[i] * cnt[j];
                    if (i == j) {
                        total -= cnt[i];
                    }
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        FriendsOfAppropriateAges fa = new FriendsOfAppropriateAges();
        System.out.println(fa.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
        System.out.println(fa.numFriendRequests(new int[]{16, 17, 18}));
    }

}
