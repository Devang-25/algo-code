package leetcode.medium;

import java.util.ArrayList;

public class ExpressiveWords {

    public int expressiveWords(String S, String[] words) {
        if(S == null || S.length() == 0 || words == null || words.length == 0){
            return 0;
        }

        ArrayList<int []> list = getList(S);
        int res = 0;
        for(int i=0;i<words.length;i++){
            ArrayList<int[]> list2 = getList(words[i]);
            if(list.size() != list2.size()){
                continue;
            }
            boolean valid = true;
            for(int j=0;j<list.size() && valid;j++){
                int [] c1 = list.get(j), c2 = list2.get(j);
                if(c1[0] != c2[0]) valid = false;
                if(c2[1] > c1[1] || (c1[1] <3 && c1[1] != c2[1])) valid = false;
            }

            if(valid) res++;
        }

        return res;

    }

    private ArrayList<int []> getList(String s){
        ArrayList<int []> res = new ArrayList<>();
        if(s.length() == 0){
            return res;
        }

        char currChar = s.charAt(0);
        int i = 1;
        int currCharCnt = 1;
        while(i < s.length()){
            if(s.charAt(i) == currChar){
                currCharCnt++;
            }else{
                res.add( new int[] {currChar, currCharCnt});
                currChar = s.charAt(i);
                currCharCnt = 1;
            }
            i++;
        }
        res.add( new int[] {currChar, currCharCnt});
        return res;
    }

    public static void main(String[] args) {
        ExpressiveWords e = new ExpressiveWords();
        System.out.println(e.expressiveWords("heelllooo", new String[]{"hello", "hi", "helo"}));
    }
}
