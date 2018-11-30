package leetcode.medium;

import java.util.Arrays;

public class RLEIterator {

    int currInd;
    int [] copy;
    public RLEIterator(int[] A) {
        currInd = 0;
        copy = Arrays.copyOf(A,A.length);
    }

    public int next(int n) {
        int cnt = 0;
        while(cnt < n && currInd < copy.length){
            cnt += copy[currInd];
            if(cnt >= n){
                copy[currInd] = (cnt-n);
                break;
            }
            currInd+=2;
        }
        if(currInd >= copy.length){
            return -1;
        }
        return copy[currInd+1];
    }

    public static void main(String[] args) {
        RLEIterator rle = new RLEIterator(new int[] {3,8,0,9,2,5});
        System.out.println(rle.next(2));
        System.out.println(rle.next(1));
        System.out.println(rle.next(1));
        System.out.println(rle.next(2));
    }
}
