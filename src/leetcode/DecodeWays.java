package leetcode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author mns
 */
public class DecodeWays {

    static class Solution {

//        public int getInt(char c) {
//            return c - '0';
//        }
//
//        public int numDecodings(String s) {
//
//            if (s.length() == 0) {
//                return 0;
//            }
//
//            int[] dp = new int[s.length() + 1];
//            Arrays.fill(dp, 1);
//
//            if (s.charAt(s.length() - 1) == '0') {
//                dp[s.length() - 1] = 0;
//            } else {
//                dp[s.length() - 1] = 1;
//            }
//
//            for (int i = s.length() - 2; i >= 0; i--) {
//
//                if (s.charAt(i) == '0') {
//                    dp[i] = 0;
//                } else {
//                    dp[i] = dp[i + 1];
//                    if (getInt(s.charAt(i)) * 10 + getInt(s.charAt(i + 1)) <= 26) {
//                        dp[i] += dp[i + 2];
//                    }
//                }
//
//            }
//
//            return dp[0];
//        }

        public int numDecodings(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0'? 0 : 1;

            for(int i=2;i<s.length()+1;i++){
                if(s.charAt(i-1) >'0' && s.charAt(i-1) <='9'){
                    dp[i] = dp[i-1];
                }
                if(s.charAt(i-2) !='0' &&
                        Integer.parseInt(s.charAt(i-2)+""+s.charAt(i-1)) <=26){
                    dp[i] += dp[i-2];
                }
            }

            return dp[s.length()];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("20203114792"));
        System.out.println(s.numDecodings("12"));
        System.out.println(s.numDecodings("209"));
        System.out.println(s.numDecodings("0"));
        System.out.println(s.numDecodings("9344300033"));
        System.out.println(s.numDecodings("209340213"));
    }
}
