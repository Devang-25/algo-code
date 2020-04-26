/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mns
 */
public class Translate {
    
    static class Val {

        String kh;
        int weight;
        
        public Val(String s, int w){
            kh = s;
            weight = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = Integer.parseInt(sc.nextLine());
        
        HashMap<String, Val> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] splits = line.split(" ");
            //System.out.println(Arrays.toString(splits));
            Val v = new Val(splits[1],Integer.parseInt(splits[2]));
            map.put(splits[0],v);
            
        }
        
        String trans = sc.nextLine();
        String [] transSplit = trans.split(" ");
        ArrayList<Val> vals = new ArrayList<>(); 
        for(int i=0;i<transSplit.length;i++){
            if(map.get(transSplit[i]) != null){
                vals.add(map.get(transSplit[i]));
            }
        }
        
        sc.close();
        
        Collections.sort(vals, new Comparator<Val>() {
            @Override
            public int compare(Val o1, Val o2) {
                return o2.weight - o1.weight;
            }
        });
        
        for(int i =0;i<vals.size();i++){
            System.out.print(vals.get(i).kh + " ");
        }
        
    }
}
