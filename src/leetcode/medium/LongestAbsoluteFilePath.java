package leetcode.medium;

import java.util.HashMap;
import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(-1,0);
        int maxLength = 0;
        String[] names = input.split("\\n");
        for(int i=0;i< names.length;i++){
            int tabs = names[i].lastIndexOf('\t')+1;
            if(names[i].indexOf('.') !=-1){
                maxLength = Math.max(maxLength, map.get(tabs-1)+names[i].length()-tabs);
            }else{
                map.put(tabs,map.get(tabs-1)+names[i].length()-tabs+1);
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        LongestAbsoluteFilePath lf = new LongestAbsoluteFilePath();
        //System.out.println(lf.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(lf.lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
    }
}
