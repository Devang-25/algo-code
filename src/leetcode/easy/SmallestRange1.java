package easy;

import java.util.Arrays;

/**
 * Created by mns on 9/22/18.
 */
public class SmallestRange1 {
    public int smallestRangeI(int[] a, int k) {
        if(a == null || a.length == 0){
            return 0;
        }

        //{-1,-2,-4,-4}  k = 2
        Arrays.sort(a);
        int small = a[0];
        int large = a[a.length-1];
        int diff = (large - small - 2*k);

        return diff < 0 ? 0:diff;

    }

    public static void main(String[] args) {
        SmallestRange1 sr = new SmallestRange1();
        System.out.println(sr.smallestRangeI(new int[]{1,3,6},3));
        System.out.println(sr.smallestRangeI(new int[]{0,10},2));
        System.out.println(sr.smallestRangeI(new int[]{1},0));
        System.out.println(sr.smallestRangeI(new int[]{-1,-2,-4,-4},-1));
    }
}
