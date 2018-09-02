package leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubStringKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0){
            return 0;
        }

        Queue<Character> queue = new LinkedList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = Integer.MIN_VALUE;

        while(left <= right && right < s.length()){
            char ch = s.charAt(right);
            queue.add(ch);
            map.put(ch, right);

            if(map.size() > k){
                while(!queue.isEmpty()){
                    char c = queue.poll();
                    if(map.get(c) == left){
                        left = map.get(c)+1;
                        map.remove(c);
                        break;
                    }
                    left++;
                }
            }

            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if(s == null || s.length() == 0 || k == 0){
            return 0;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = Integer.MIN_VALUE;

        while(left <= right && right < s.length()){
            char ch = s.charAt(right);
            map.put(ch, right);

            if(map.size() > k){
                while(left <= right){
                    char c = s.charAt(left);
                    if(map.get(c) == left){
                        left = map.get(c)+1;
                        map.remove(c);
                        break;
                    }
                    left++;
                }
            }

            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStringKDistinctCharacters ls = new LongestSubStringKDistinctCharacters();
//        System.out.println(ls.lengthOfLongestSubstringKDistinct("eceba",2));
//        System.out.println(ls.lengthOfLongestSubstringKDistinct("aa",1));
        System.out.println(ls.lengthOfLongestSubstringKDistinct("ababffzzeee",1));
    }
}
