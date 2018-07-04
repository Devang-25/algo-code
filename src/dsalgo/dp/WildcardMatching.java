package dsalgo.dp;


/**
 * Created by mns on 6/25/18.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {

        boolean [][] dp = new boolean [p.length()+1][s.length()+1];
        dp[0][0] = true;

        for(int i=1;i<p.length()+1;i++){
            if(p.charAt(i-1) == '*'){
                dp[i][0] = true;
            }else{
                break;
            }
        }

        for(int i=1;i<p.length()+1;i++){
            for(int j=1;j<s.length()+1;j++){
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch("acdcb","a*c?b"));
        System.out.println(wm.isMatch("aa","*"));
    }

}
