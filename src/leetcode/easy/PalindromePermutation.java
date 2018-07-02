package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                continue;
            }
            set.remove(s.charAt(i));

        }
        return set.size()==0 || set.size()==1;
    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.canPermutePalindrome("haha"));
    }
}
