package leetcode.hard;

import java.util.HashMap;

/**
 * Created by mns on 10/13/18.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        HashMap<String,Boolean> dp = new HashMap<>();
        return util(s1,s2,s3,0,0,0, dp);
    }

    private boolean util(String s1, String s2, String s3, int i, int j, int k, HashMap<String,Boolean> dp){

        if( i== s1.length() && j == s2.length() && k == s3.length()){
            return true;
        }

        String hash = i + "," + j + "," + k;
        Boolean result = false;
        if(dp.containsKey(hash)){
            return dp.get(hash);
        }

        if( i< s1.length() && j <s2.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
            result = util(s1,s2,s3,i+1,j,k+1,dp) || util(s1,s2,s3,i,j+1,k+1,dp);
        }else if(i<s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)){
            result = util(s1,s2,s3,i+1,j,k+1,dp);
        }else if(j<s2.length() && k<s3.length() && s2.charAt(j) == s3.charAt(k)){
            result = util(s1,s2,s3,i,j+1,k+1,dp);
        }

        dp.put(hash,dp.getOrDefault(hash,false) || result);
        return dp.get(hash);
    }

    public static void main(String[] args) {
        InterleavingString ils = new InterleavingString();
        System.out.println(ils.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
