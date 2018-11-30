package leetcode.easy;

import java.util.*;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digit = new ArrayList<>();
        ArrayList<String> letter = new ArrayList<>();
        for(String s : logs){
            String[] splits = s.split("\\s+");
            if(Character.isDigit(splits[1].charAt(0))){
                digit.add(s);
            }else{
                letter.add(s);
            }
        }

        Collections.sort(letter, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String [] splits1 = o1.split("\\s+");
                String [] splits2 = o2.split("\\s+");
                int l = Math.min(splits1.length, splits2.length);
                for(int i =1;i<l;i++){
                    int x = splits1[i].compareTo(splits2[i]);
                    if(x !=0){
                        return x;
                    }
                }

                int x = Integer.compare(splits1.length, splits2.length);
                if(x == 0){
                    return splits1[0].compareTo(splits2[0]);
                }
                return x;
            }
        });

        String [] result = new String[logs.length];
        int i =0;
        for(String s : letter){
            result[i++] = s;
        }

        for(String s : digit){
            result[i++] = s;
        }

        return result;
    }

    public static void main(String[] args) {
        ReorderLogFiles r = new ReorderLogFiles();
        System.out.println(Arrays.toString(r.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
        System.out.println(Arrays.toString(r.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a1 acto car","a8 act zoo"})));
    }
}
