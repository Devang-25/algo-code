package leetcode.hard;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class OrderlyQueue {

    ///BAD SOLUTION
    public String orderlyQueue(String S, int K) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        LinkedList<Character> l = new LinkedList<>();
        for(int i=0;i<S.length();i++){
            pq.add(S.charAt(i));
            l.addLast(S.charAt(i));
        }
        int i = 0; String pre = "";
        while(i++ < K){
            pre += pq.poll();
        }

        while(!startsWith(l,pre)){
            int largest = 0,k = 1;
            ListIterator<Character> it = l.listIterator();
            char largestCh = it.next();
            while(k < K){
                char next = it.next();
                if(largestCh < next){
                    largestCh = next;
                    largest = k;
                }
                k++;
            }
            l.remove(largest);
            l.addLast(largestCh);
        }
        StringBuilder sb = new StringBuilder();
        ListIterator<Character> it = l.listIterator();
        while(it.hasNext()){
            sb.append(it.next());
        }

        return sb.toString();
    }

    private boolean startsWith(LinkedList<Character> l, String s){
        int x = s.length();
        ListIterator<Character> it = l.listIterator();
        for(int i=0;i<x;i++){
            if(it.next() != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
