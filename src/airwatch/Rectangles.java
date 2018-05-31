/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airwatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mns
 */
public class Rectangles {

    public static boolean valid(int a, int b, int c, int d) {
        if (a == b && c == d) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            String[] lens = line.split(" ");
            if (lens.length < 4) {
                System.out.println("0");
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                HashMap<Integer,Integer> map = new HashMap<>();
                for (int k = 0; k < lens.length; k++) {
                    list.add(Integer.parseInt(lens[k]));
                }
               
                for (int k = 0; k < lens.length; k++) {
                    Integer curr = list.get(k);
                    Integer val = map.get(curr);
                    if(val== null){
                        map.put(curr, 1);
                    }else{
                        map.put(curr,val+1);
                    }
                }
                
                int pairs = 0;
                for(Integer in : map.values()){
                    pairs+=in/2;
                }

                System.out.println(pairs/2);
                
                
            }

        }
    }
}
