package leetcode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sekha
 */
public class MinAsciiDelete {

    public int minimumDeleteSum(String s1, String s2) {
        int[][] mem = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= mem.length; i++) {
            for (int j = 0; j <= mem[0].length; j++) {
                if (i == 0) {
                    mem[i][j] = s2.charAt(j);
                } else if (j == 0) {
                    mem[i][j] = s1.charAt(i);
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    mem[i][j] = mem[i - 1][j - 1];
                } else {
                    mem[i][j] = min(mem[i - 1][j] + s1.charAt(i), mem[i][j - 1] + s2.charAt(j),
                            mem[i - 1][j - 1] + s1.charAt(i) + s2.charAt(j));
                }
            }
        }

        return mem[s1.length()][s2.length()];
    }

    private int min(int a, int b, int c) {
        if (a <= b) {
            if (c <= a) {
                return c;
            }
            return a;
        } else {
            if (c <= b) {
                return c;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        MinAsciiDelete m = new MinAsciiDelete();
        System.out.println(m.minimumDeleteSum("sea", "eat"));
        System.out.println(m.minimumDeleteSum("delete", "leet"));
    }
}
