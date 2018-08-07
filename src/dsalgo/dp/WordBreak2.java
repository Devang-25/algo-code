package dsalgo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> result = wordBreakUtil(s,wordDict, map);
        return result;
    }

    public List<String> wordBreakUtil(String s, List<String> wordDict,HashMap<String,List<String>> map) {
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if(s.length() == 0){
            result = Arrays.asList("");
            map.put("",result);
            return result;
        }
        for(String x : wordDict){
            if(s.startsWith(x)){
                List<String> list = wordBreakUtil(s.substring(x.length()), wordDict,map);
                for(String y : list){
                    result.add(x + (!y.isEmpty()? " "+y : ""));
                }
            }
        }

        map.put(s,result);
        return result;

    }

    public static void main(String[] args) {
        WordBreak2 wb = new WordBreak2();
//        List<String> s = Arrays.asList("cat", "cats", "and", "sand", "dog");
//        wb.wordBreak("catsanddog",s).stream().forEach(System.out::println);
//        List<String> s = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
//        wb.wordBreak("pineapplepenapple",s).stream().forEach(System.out::println);
        List<String> s = Arrays.asList("aaaa","aa","a");
        wb.wordBreak("aaaaaaa",s).stream().forEach(System.out::println);
    }

}
