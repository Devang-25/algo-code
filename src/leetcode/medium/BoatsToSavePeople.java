package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        ArrayList<Integer> p = new ArrayList<>();
        for(Integer i : people){
            p.add(i);
        }

        Collections.sort(p,(a,b) -> b-a);
        int total = 0;
        int l=0,r=p.size()-1;
        while(l <= r && l<p.size()){
            if(l != r && p.get(l) + p.get(r) <= limit){
                r--;
            }
            total++;
            l++;
        }
        return total;
    }


    public static void main(String[] args) {
        BoatsToSavePeople bs= new BoatsToSavePeople();
//        System.out.println(bs.numRescueBoats(new int[]{3,5,3,4},5));
//        System.out.println(bs.numRescueBoats(new int[]{3,2,2,1},3));
//        System.out.println(bs.numRescueBoats(new int[]{3,2,2,1},10));
//        System.out.println(bs.numRescueBoats(new int[]{5,1,4,2},6));
        System.out.println(bs.numRescueBoats(new int[]{5,1,7,4,2,4},7));
    }
}
