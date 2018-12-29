package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeateElements {
    public int repeatedNTimes(int[] a) {
        if(a == null || a.length == 0){
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for(int i : a){
            if(set.contains(i)){
                return i;
            }else{
                set.add(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NRepeateElements n = new NRepeateElements();
        System.out.println(n.repeatedNTimes(new int [] {1,2,3,3}));
    }
}
