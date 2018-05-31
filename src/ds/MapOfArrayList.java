/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mns
 */
public class MapOfArrayList {
    
    public static void printMap(Map<String,ArrayList<String>> map){
        for(String str : map.keySet()){
            System.out.print(str+"--->");
            for(String str1 : map.get(str)){
                System.out.print(str1+", ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        Map<String,ArrayList<String> > map = new HashMap<>();
        map.put("Sea", new ArrayList<>(Arrays.asList(new String[]{"a","b","c"})));
        printMap(map);
        map.get("Sea").add("d");
        printMap(map);
    }
}
