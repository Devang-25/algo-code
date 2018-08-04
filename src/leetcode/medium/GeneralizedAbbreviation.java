package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
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
        GeneralizedAbbreviation ga = new GeneralizedAbbreviation();
        ga.generateAbbreviations("word").stream().forEach(System.out::println);
    }
}
