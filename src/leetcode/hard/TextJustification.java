package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String [] words, int maxWidth){
        List<String> result = new ArrayList<>();
        StringBuffer currentLine = new StringBuffer();
        int startWord = 0, spacesRemaining = maxWidth;
        for(int i=0;i<words.length;i++){
            if(words[i].length() > spacesRemaining){
                int spaces = i-startWord-1 <=0 ? 0 : i-startWord-1;
                spacesRemaining += i-startWord;
                for(int j=startWord; j<i;j++){
                    currentLine.append(words[j]);
                    if(spaces > 0) {
                        int avgSpace = (int) Math.ceil(spacesRemaining / (double)spaces);
                        currentLine.append(spaces(avgSpace));
                        spacesRemaining -= avgSpace;
                        spaces--;
                    }else{
                        currentLine.append(spaces(spacesRemaining));
                    }
                }

                result.add(currentLine.toString());
                spacesRemaining = maxWidth;
                startWord = i;
                currentLine.setLength(0);
                i--;

            }else{
                spacesRemaining -= (words[i].length()+1);
            }
        }

        for(int j = startWord; j<words.length;j++){
            currentLine.append(words[j]);
            if(j!=words.length-1){
                currentLine.append(' ');
            }
        }

        if(currentLine.length() > 0){
            currentLine.append(spaces(maxWidth - currentLine.length()));
            result.add(currentLine.toString());
        }
        return result;
    }

    String spaces( int n){
        if(n > 0) {
            char[] ch = new char[n];
            Arrays.fill(ch, ' ');
            return String.valueOf(ch);
        }
        return "";
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        tj.fullJustify(new String []{"This", "is", "an", "example", "of", "text", "justification."}, 16).stream().forEach(System.out::println);
        tj.fullJustify(new String []{"What","must","be","acknowledgment","shall","be"}, 16).stream().forEach(System.out::println);
        tj.fullJustify(new String []{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"}, 20).stream().forEach(System.out::println);
        tj.fullJustify(new String []{"Listen","to","many,","speak","to","a","few."}, 6).stream().forEach(System.out::println);
    }
}
