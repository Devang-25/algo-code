package dsalgo.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean [s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j = i-1;j>=0;j--){
                dp[i] = dp[j] && set.contains(s.substring(j,i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("leetcode", Arrays.asList("leet","code")));
    }
}
