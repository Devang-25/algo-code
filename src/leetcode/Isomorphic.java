/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author sekha
 */
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t==null || s.length() != t.length()){
            return false;
        }
        
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character val = map.get(s.charAt(i));
            if(val == null){
                if(!map.containsValue(t.charAt(i))){
                    map.put(s.charAt(i), t.charAt(i));
                }else{
                    return false;
                }
            }else{
                if(t.charAt(i) != val){
                    return false;
                }
            }
        }
        
        return true;
        
    }
    
    public static void main(String[] args) {
        Isomorphic iso = new Isomorphic();
        System.out.println(iso.isIsomorphic("paper", "title"));
         System.out.println(iso.isIsomorphic("egg", "add"));
         System.out.println(iso.isIsomorphic("foo", "bar"));

    }
}
