/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class PhoneDirectory {
    private HashSet<Integer> assigned = null;
    private ArrayDeque<Integer> released = null;
    int max = Integer.MIN_VALUE;
    public PhoneDirectory(int maxNumbers) {
        assigned = new HashSet<>();
        released = new ArrayDeque<>();
        for(int i=0;i<maxNumbers;i++){
            released.offer(i);
        }
        max = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int num = -1;
        if(!released.isEmpty()){
            num = released.poll();
            assigned.add(num);
        }
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return number < max && number >= 0 && !assigned.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(number >=0 && number < max && assigned.contains(number)){
            assigned.remove(number);
            released.offer(number);
        }
    }
    
    public static void main(String[] args) {
        PhoneDirectory pd = new PhoneDirectory(3);
        System.out.println(pd.get());
        System.out.println(pd.get());
        System.out.println(pd.check(2));
        System.out.println(pd.get());
        System.out.println(pd.check(2));
        pd.release(2);
        System.out.println(pd.check(2));
    }
}
