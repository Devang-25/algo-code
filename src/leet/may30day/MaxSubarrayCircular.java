package leet.may30day;

import java.util.Arrays;

public class MaxSubarrayCircular {
  public int maxSubarraySumCircular(int[] a) {
    if (a == null || a.length == 0) {
      return 0;
    }
    int maxSum = kadane(a);
    int sum = 0;
    int max = Integer.MIN_VALUE;
    // int min = Arrays.stream(a).max().getAsInt();
    // if (min < 0) {
    // return min;
    // }

    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }

    if (max < 0)
      return max;

    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      a[i] = -a[i];
    }

    int maxSum2 = kadane(a);

    if (sum + maxSum2 > maxSum) {
      return sum + maxSum2;
    }

    return maxSum;
  }

  int kadane(int[] a) {
    int maxSum = Integer.MIN_VALUE, sumSoFar = 0;
    for (int i = 0; i < a.length; i++) {
      sumSoFar += a[i];
      maxSum = Math.max(sumSoFar, maxSum);
      if (sumSoFar <= 0) {
        sumSoFar = 0;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    MaxSubarrayCircular m = new MaxSubarrayCircular();
    System.out.println(m.maxSubarraySumCircular(new int[] { -1 }));
    System.out.println(m.maxSubarraySumCircular(new int[] { -1, -2, -3, 1, -4, -5 }));
    System.out.println(m.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
    System.out.println(m.maxSubarraySumCircular(new int[] { 5, -3, 5 }));
    System.out.println(m.maxSubarraySumCircular(new int[] { 3, -1, 2, -1 }));
    System.out.println(m.maxSubarraySumCircular(new int[] { 3, -2, 2, -3 }));
    System.out.println(m.maxSubarraySumCircular(new int[] { -2, -3, -1 }));
  }
}
