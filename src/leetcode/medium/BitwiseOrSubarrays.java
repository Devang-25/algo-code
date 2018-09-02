package leetcode.medium;

import java.util.HashSet;

public class BitwiseOrSubarrays {

    ///BAD SOLUTION
    public int subarrayBitwiseORs(int[] a) {
        if(a == null || a.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            int or = a[i];
            set.add(or);
            for(int j=i+1;j<a.length;j++){
                or = or | a[j];
                set.add(or);
            }
        }

        return set.size();

    }

    public static void main(String[] args) {
        BitwiseOrSubarrays bos = new BitwiseOrSubarrays();
        System.out.println(bos.subarrayBitwiseORs(new int[]{1,1,2}));
        System.out.println(bos.subarrayBitwiseORs(new int[]{1,2,4}));
    }
}
