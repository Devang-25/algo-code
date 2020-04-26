/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author sekha
 */
public class FindAndReplace {
    
    class StringPair {
        String source,target;

        private StringPair(String source, String target) {
           this.source = source;
           this.target = target;
        }
    }
    
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer,StringPair> map = new TreeMap<>();
        for(int i =0 ;i<indexes.length;i++){
            fillMap(map,sources[i],targets[i], S, indexes[i]);
        }
        
        int index = 0;
        for(Map.Entry<Integer,StringPair> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue().source + " " + entry.getValue().target);
            int top = entry.getKey();
            while(index < top){
                sb.append(S.charAt(index));
                index++;
            }
            sb.append(entry.getValue().target);
            index+=entry.getValue().source.length();
        }
        while(index < S.length()){
            sb.append(S.charAt(index));
            index++;
        }
        return sb.toString();
     }

    
    private Set<Integer> findAllOccurances(String S, String s){
        HashSet<Integer> set = new HashSet<>();
        int find  = S.indexOf(s);
        while(find != -1){
            set.add(find);
            find = S.indexOf(s, find+1);
        }
        return set;
    }
    
    private void fillMap(TreeMap<Integer,StringPair> map,String source,String target, String S, int index){
        Set<Integer> occurances = findAllOccurances(S, source);
        if(occurances.contains(index)){
            map.put(index,new StringPair(source,target));
        }
    }
    
    public static void main(String[] args) {
        FindAndReplace fr = new FindAndReplace();
        System.out.println(fr.findReplaceString("abcd", new int []{0,2}, new String[]{"a","cd"},
                new String[]{"eee","ffff"}));
        System.out.println(fr.findReplaceString("abcd", new int []{0,2}, new String[]{"ab","ec"},
                new String[]{"eee","ffff"}));
    }
}
