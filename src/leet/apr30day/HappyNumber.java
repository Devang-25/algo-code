package leet.apr30day;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int num = n, sum, x;
        do {
            visited.add(num);
            sum = 0;
            while(num !=0 ) {
                x = num % 10;
                sum += x*x;
                num = num/10; 
            }

            num = sum;
            if(sum == 1 ) return true;
            if(visited.contains(sum)) return false;
        }while(true);
    }

    public static void main(String [] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(19));
    }
}