package leetcode.medium;

import java.util.Arrays;

/**
 * Created by mns on 10/14/18.
 */
public class ThreeSumMulti {
    public int threeSumMulti(int[] num, int target) {
        Arrays.sort(num);
        int cnt = 0;
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1;
                while (lo < hi) {
                    if (num[lo] + num[hi] + num[i] == target) {
                        cnt++;
                        while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
                            cnt++;
                        }
                        while (lo < hi && num[hi] == num[hi-1]) {
                            hi--;
                            cnt++;
                        }
                        lo++; hi--;
                    } else if (num[lo] + num[hi] + num[i] < target) lo++;
                    else hi--;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ThreeSumMulti t = new ThreeSumMulti();
        System.out.println(t.threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }
}
