package leetcode.easy;

import java.util.Arrays;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() <= 1){
            return false;
        }

        int index1 = -1;
        int index2 = -1;
        int [] map = new int [26];
        Arrays.fill(map,0);
        for(int i=0;i<A.length();i++){
            if(A.charAt(i) != B.charAt(i)){
                if(index1 < 0){
                    index1 = i;
                }else  if(index2 < 0){
                    index2 = i;
                }else {
                    return false;
                }
            }else{
                map[A.charAt(i)-'a']++;
                if(map[A.charAt(i)-'a'] > 1){
                    return true;
                }
            }
        }

        return index1 >=0 && index2 >=0
                && (A.charAt(index1) == B.charAt(index2))
                && (A.charAt(index2) == B.charAt(index1));
    }

    public static void main(String[] args) {
        BuddyStrings bs = new BuddyStrings();
        System.out.println(bs.buddyStrings("aaaaaaabc", "aaaaaaacb" ));
        System.out.println(bs.buddyStrings("ab", "ab" ));
        System.out.println(bs.buddyStrings("ab", "ba" ));
    }
}
