package leetcode.medium;

import java.util.Random;

public class RandomPickWeight {
    int [] sum;
    public RandomPickWeight(int [] w){
        sum = new int[w.length];
        sum[0] = w[0];
        for(int i=1;i<w.length;i++){
            sum[i] = sum[i-1]+w[i];
        }
    }

    public int pickIndex() {
        Random rdm = new Random();
        int rand = rdm.nextInt(sum[sum.length-1]);
        int l = 0, r = sum.length;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(rand == sum[mid]){
                return mid;
            }else if(sum[mid] > rand){
                r = mid-1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }
}
