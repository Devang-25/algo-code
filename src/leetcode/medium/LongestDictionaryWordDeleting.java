package leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mns on 7/12/18.
 */
public class LongestDictionaryWordDeleting {
    public String findLongestWord(String s, List<String> d) {
        int maxLength = Integer.MIN_VALUE;
        String maxWord = "";
        for(String word : d){
            int ind = 0;
            for(int i=0;i<s.length() && ind < word.length();i++){
                if(s.charAt(i) == word.charAt(ind)){
                    ind++;
                }
            }

            if(ind == word.length() && maxLength <= word.length()){
                maxLength = word.length();
                if(maxWord.length() == word.length()){
                    maxWord = maxWord.compareTo(word) < 0? word: maxWord;
                }else{
                    maxWord = word;
                }
            }
        }

        return maxWord;

    }

    public static void main(String[] args) {
        LongestDictionaryWordDeleting ld = new LongestDictionaryWordDeleting();
        System.out.println(ld.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }

}
