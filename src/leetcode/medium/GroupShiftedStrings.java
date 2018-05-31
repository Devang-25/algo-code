/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sekha
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String> > result = new ArrayList<>();
        HashMap<String, List<String> > map = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            String enc = encode(strings[i]);
            List<String> list = map.get(enc);
            if(list == null){
                list = new ArrayList<>();
                map.put(enc, list);
                result.add(list);
            }
            list.add(strings[i]);
        }
        return result;
    }
    
    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int offset = 'z' - s.charAt(0);
        for(int i=0;i<s.length();i++){
            sb.append((char)(s.charAt(i) + offset <= 'z'? s.charAt(i) + offset :
                    s.charAt(i) + offset -26));
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        GroupShiftedStrings ga = new GroupShiftedStrings();
        List<List<String> > res = ga.groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
        
        for(List<String> list : res){
            for(String s : list){
                System.out.println(s + ",");
            }
            System.out.println("");
        }
    }
}
