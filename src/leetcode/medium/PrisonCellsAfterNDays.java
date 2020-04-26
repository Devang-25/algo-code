package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N == 0){
            return cells;
        }
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer,String> revMap = new HashMap<>();
        for(int i=0;i<8;i++){
            sb.append(cells[i]);
        }

        int day = 0;
        map.put(sb.toString(),day);
        revMap.put(day,sb.toString());
        while(true){
            StringBuilder cpy = new StringBuilder(sb);
            for(int i=0;i<8;i++){
                if(i == 0 || i == 7){
                    cpy.setCharAt(i,'0');
                }else{
                    if(sb.charAt(i-1) == sb.charAt(i+1)){
                        cpy.setCharAt(i,'1');
                    }else{
                        cpy.setCharAt(i,'0');
                    }
                }
            }
            sb = cpy;
            day++;
            if(day == N){
                return stringToArray(sb.toString());
            }
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(),day);
                revMap.put(day,sb.toString());
            }else{
                int prevOccurrance = map.get(sb.toString());
                int remainingDays = N - day;
                int length = day - prevOccurrance;

                return stringToArray(revMap.get(prevOccurrance + (remainingDays % length)));

            }
        }

    }

    private int [] stringToArray(String s) {
        int [] result = new int[8];
        for(int i=0;i<s.length();i++){
            result[i] = s.charAt(i)-'0';
        }
        return result;
    }

    public static void main(String[] args) {
        PrisonCellsAfterNDays p = new PrisonCellsAfterNDays();
        System.out.println(Arrays.toString(p.prisonAfterNDays(new int []{0,1,0,1,1,0,0,1}, 7 )));
        System.out.println(Arrays.toString(p.prisonAfterNDays(new int []{1,0,0,1,0,0,1,0},  1000000000)));
    }
}
