package dsalgo.dp;

public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        boolean [][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for(int i=1;i<p.length()+1;i++){
            if(p.charAt(i-1) == '*'){
                dp[i][0] = dp[i-2][0];
            }
        }

        for(int i=1;i<p.length()+1;i++){
            for(int j=1;j<s.length()+1;j++){
                if(s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(i-1) == '*' ){
                    if(s.charAt(j-1) == p.charAt(i-2) || p.charAt(i-2) == '.'){
                        dp[i][j] = dp[i][j-1] || dp[i-2][j];
                    }else{
                        dp[i][j] = dp[i-2][j];
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }

        for(int i=0;i<p.length()+1;i++) {
            for (int j = 0; j < s.length() + 1; j++) {
                System.out.print(dp[i][j]? "T ":"F ");
            }
            System.out.println();
        }
        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        RegularExpressionMatch re = new RegularExpressionMatch();
//        System.out.println(re.isMatch("aab","c*a*b"));
//        System.out.println(re.isMatch("aa","a*"));
//        System.out.println(re.isMatch("ab",".*"));
//        System.out.println(re.isMatch("mississippi","mis*is*p*."));
//        System.out.println(re.isMatch("mississippi","mis*is*ip*."));
        System.out.println(re.isMatch("aaa","ab*a*c*a"));
    }
}
