/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlesample;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mns
 */
public class AllPaths {

    public int[][] touchCounter = null;
    public int[][] touchCounter2 = null;
    public int[][] dp = null;
    public boolean[][] inp = null;
    private int N;
    private static final Scanner sc = new Scanner(System.in);

    public AllPaths(int N) {
        this.N = N;
        touchCounter = new int[N][N];
        touchCounter2 = new int[N][N];
        dp = new int[N][N];
        inp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] bools = line.split(" ");
            System.out.println(Arrays.toString(bools));
            for (int j = 0; j < N; j++) {
                if (bools[i].contentEquals("1")) {
                    inp[i][j] = true;
                } else {
                    inp[i][j] = false;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(touchCounter[i], 0);
            Arrays.fill(dp[i], -1);
            Arrays.fill(touchCounter2[i], 0);

        }
    }

    public void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void printArray(boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] ? "1 " : "0 ");
            }
            System.out.println("");
        }
    }

    public int recursion(boolean[][] arr, int i, int j) {
        int totalPaths = 0;
        if (i >= 0 && j >= 0) {
            touchCounter[i][j] += 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        } else if (i == 0 && j == 0) {
            return 1;
        } else if (arr[i][j]) {
            totalPaths = recursion(arr, i - 1, j) + recursion(arr, i, j - 1);
        } else {
            return 0;
        }

        return totalPaths;
    }

    public int dynamic(boolean[][] arr, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] == -1) {
            if (i >= 0 && j >= 0) {
                touchCounter2[i][j] += 1;
            }
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else if (i == 0 && j == 0) {
            return 1;
        } else if (arr[i][j]) {
            dp[i][j] = dynamic(arr, i - 1, j) + dynamic(arr, i, j - 1);
        } else {
            return 0;
        }
        return dp[i][j];
    }

    public void solve() {
        System.out.println(recursion(inp, N - 1, N - 1));
        printArray(touchCounter);
        System.out.println(dynamic(inp, N - 1, N - 1));
        printArray(touchCounter2);
    }

    public static void main(String[] args) {
        int N;

        N = Integer.parseInt(sc.nextLine());
        AllPaths sol = new AllPaths(N);
        System.out.println("-----");
        sol.solve();
    }
}
