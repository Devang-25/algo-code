package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinimumUniqueWordAbbreviation {

    HashSet<String> dicAbbrs = new HashSet<>();
    public String minAbbreviation(String target, String[] dictionary) {
        List<String> list = generateAbbreviations(target);
        int minLength = Integer.MAX_VALUE;
        String minAbbr = "";

        for(String s : list){
            boolean found = false;
            for(String ds : dictionary){
                if(validWordAbbreviation(ds,s)){
                    found = true;
                    break;
                }
            }

            if(!found && s.length() < minLength){
                minAbbr = s;
                minLength = s.length();
            }
        }
        return minAbbr;
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int index = 0;
        int acc = 0;
        for(int i=0;i<abbr.length();i++){
            if(Character.isAlphabetic(abbr.charAt(i))){
                index += acc;
                if(index >= word.length() || abbr.charAt(i) != word.charAt(index) ){
                    return false;
                }
                acc = 0;
                index++;
            }else if(Character.isDigit(abbr.charAt(i))){
                if(abbr.charAt(i) == '0' && acc == 0){
                    return false;
                }
                acc = acc*10 + (abbr.charAt(i)-'0');
            }
        }
        index += acc;
        return index == word.length();
    }

    public String minAbbreviation2(String target, String[] dictionary) {
        for(String s : dictionary){
            dicAbbrs.addAll(generateAbbreviations(s));
        }
        List<String> list = generateAbbreviations(target);
        int minLength = Integer.MAX_VALUE;
        String minAbbr = "";

        for(String s : list){
            if(dicAbbrs.contains(s)) continue;
            if(s.length() < minLength){
                minAbbr = s;
                minLength = s.length();
            }
        }
        return minAbbr;
    }

    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        generateAbbreviations(word,0,"",0,result);
        return result;
    }

    public void generateAbbreviations(String word, int index, String acc, int abbrLength, List<String> result){
        if(index == word.length()){
            if(abbrLength != 0){
                acc += abbrLength;
            }
            result.add(acc);
            return;
        }

        generateAbbreviations(word, index+1,acc,abbrLength+1,result);
        generateAbbreviations(word, index+1,acc+(abbrLength!=0?abbrLength:"")+word.charAt(index),0,result);

    }

    public static void main(String[] args) {
        MinimumUniqueWordAbbreviation mq = new MinimumUniqueWordAbbreviation();
        System.out.println(mq.minAbbreviation("apple", new String[]{"blade"}));
    }
}
