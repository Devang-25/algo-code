/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class ValidWordAbbr {

    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder newAbbr = new StringBuilder();
        int num = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (Character.isDigit(abbr.charAt(i))) {
                num = num * 10 + abbr.charAt(i) - '0';
                if(num == 0 && abbr.charAt(i) == '0' || num >= word.length()){
                    return false;
                }

            } else {
                for (int j = 0; j < num; j++) {
                    newAbbr.append('#');
                }
                newAbbr.append(abbr.charAt(i));
                num = 0;
            }
        }

        for (int j = 0; j < num; j++) {
            newAbbr.append('#');
        }

        if (newAbbr.length() != word.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (newAbbr.charAt(i) == '#') {
                continue;
            }

            if (newAbbr.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ValidWordAbbr v = new ValidWordAbbr();
        System.out.println(v.validWordAbbreviation("apple", "a2e"));
        System.out.println(v.validWordAbbreviation("internationalization", "i12iz4n"));
    }
}
