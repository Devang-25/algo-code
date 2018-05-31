package leetcode.easy;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by mns on 5/25/18.
 */
public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {

        ArrayList<String> result = new ArrayList<>();
        boolean [] set = new boolean[10];
        readBinaryWatchUtil(num,result,set,0);
        return result;

    }
    private void readBinaryWatchUtil(Integer num, ArrayList<String> result,boolean [] set, int index){
        if(num == 0){
            int h = 0, m = 0;
            for(int i=0;i<10;i++){
                if(i<6 && set[i]){
                    m += Math.pow(2,i);
                }else if(i >=4 && set[i]){
                    h += Math.pow(2,i-6);
                }
            }
            if(isValid(h, m)){
                result.add(h + ":" + (m < 10? ("0"+m):m));
            }
            return;
        }else if(index >= 10){
            return;
        }

        for(int i=index;i < 10;i++){
            set[i] = true;
            readBinaryWatchUtil(num-1,result,set,index+1);
            set[i] = false;
        }
    }

    private boolean isValid(int hours, int mins){
        if(hours >11 || mins > 59){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryWatch bw = new BinaryWatch();
        bw.readBinaryWatch(2).stream().forEach(System.out::println);
    }
}
