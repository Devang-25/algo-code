/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class UniqueMorseCode {
    
    private static final String [] MAP = new String[] {
        ".-","-...","-.-.","-..",".","..-.","--.","....","..",
        ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
        "...","-","..-","...-",".--","-..-","-.--","--.."
    };
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> result = new HashSet<>();
        for(int i=0;i<words.length;i++){
            StringBuilder sb = new StringBuilder();
            for(char c : words[i].toCharArray()){
                sb.append(MAP[c-'a']);
            }
            result.add(sb.toString());
        }
        
        return result.size();
    }
    
    public static void main(String[] args) {
        UniqueMorseCode u = new UniqueMorseCode();
        System.out.println(u.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
                
    }
}
