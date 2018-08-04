package leetcode.easy;

import leetcode.medium.ValidWordAbbr;

public class ValidWordAbbreviation {
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

    public static void main(String[] args) {
        ValidWordAbbreviation v = new ValidWordAbbreviation();
        System.out.println(v.validWordAbbreviation("internationalization","i18n"));
        System.out.println(v.validWordAbbreviation("apple","a2l1"));
    }

}
