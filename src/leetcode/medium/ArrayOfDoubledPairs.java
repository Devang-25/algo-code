package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] a) {
        if(a == null || a.length == 0){
            return true;
        }
        Arrays.sort(a);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.put(a[i], map.getOrDefault(a[i],0)+1);
        }

        for(int i=0;i<a.length ;i++){
            Integer curr = map.get(a[i]);
            if( curr == 0){
                continue;
            }
            Integer half = 0;
            if(a[i]%2 == 0) {
                half = map.get(a[i] / 2) == null ? 0 : map.get(a[i] / 2);
            }
            Integer dub = map.get(a[i]*2) == null ? 0 : map.get(a[i] * 2);

            if( curr > (half+dub)){
                return false;
            }

            if(half != 0){
                map.put(a[i]/2, half - Math.min(curr,half));
                curr -= Math.min(curr,half);
            }
            if(dub != 0){
                map.put(a[i]*2, dub - curr);
            }
            map.put(a[i],0);

        }

        for(int i=0;i<a.length;i++){
            if(map.get(a[i]) != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ArrayOfDoubledPairs ad = new ArrayOfDoubledPairs();
        System.out.println(ad.canReorderDoubled(new int [] {4,-2,2,-4}));
        System.out.println(ad.canReorderDoubled(new int [] {1,2,4,16,8,4}));
        System.out.println(ad.canReorderDoubled(new int [] {1,2,4,16,8,8}));
        System.out.println(ad.canReorderDoubled(new int [] {3,1,3,6}));
        System.out.println(ad.canReorderDoubled(new int [] {2,1,2,6}));
        System.out.println(ad.canReorderDoubled(new int [] {0,4,0,2,-6,-4,8,-3,0,0,2,-6,-3,-6,-2,-3,1,4}));
    }

}
