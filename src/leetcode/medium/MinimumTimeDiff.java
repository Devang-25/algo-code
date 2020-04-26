package leetcode.medium;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Created by mns on 7/2/18.
 */
public class MinimumTimeDiff {
    public int findMinDifference(List<String> timePoints) {
        BitSet bt = new BitSet(24*60);
        for(String st  : timePoints){
            int hours = Integer.parseInt(st.substring(0,2));
            int minutes = hours*60+Integer.parseInt(st.substring(3));
            if(bt.get(minutes)){
                return 0;
            }
            bt.set(minutes);
        }

        int index = bt.nextSetBit(0);
        int first = bt.nextSetBit(0);
        int minDiff = Integer.MAX_VALUE;
        while(index < bt.size()){
            int next = bt.nextSetBit(index+1);
            if(next!=-1){
                minDiff = Math.min(next - index, minDiff);
                index = next;
            }else{
                minDiff = Math.min(24*60+first - index,minDiff);
                break;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        MinimumTimeDiff mtd = new MinimumTimeDiff();
        System.out.println(mtd.findMinDifference(Arrays.asList("23:59","00:00")));
        System.out.println(mtd.findMinDifference(Arrays.asList("05:31","22:08","00:35")));
    }
}
