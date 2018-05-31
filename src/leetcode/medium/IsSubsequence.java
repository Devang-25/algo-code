package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mns on 5/9/18.
 */
public class IsSubsequence {
    //Only consists of lowercase letters

    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null){
            return false;
        }

        int tIndex = 0;
        for(int i=0; i< s.length();i++){
            while(tIndex < t.length() && t.charAt(tIndex) != s.charAt(i)){
                tIndex += 1;
            }
            if(tIndex >= t.length()){
                return false;
            }
            tIndex++;
        }

        return true;
    }

    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence("abc",""));
        System.out.println(is.isSubsequence("abc","ahbgdc"));
    }
}
