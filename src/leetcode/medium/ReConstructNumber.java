package leetcode.medium;

import java.util.Arrays;

/**
 * Created by mns on 8/22/18.
 */
public class ReConstructNumber {
    String [] nums = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
    public String originalDigits2(String s) {
        int [] cnt = new int[26];
        int l = s.length();
        for(int i=0;i<l;i++){
            cnt[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < l){
            for(int i=0;i<nums.length;i++){
                int len = nums[i].length();
                int [] cpy = Arrays.copyOf(cnt,26);
                boolean match = true;
                for(int j=0;j<len;j++){
                    if(cnt[nums[i].charAt(j)-'a'] >= 1){
                        cnt[nums[i].charAt(j)-'a']--;
                    }else{
                        match = false;
                        break;
                    }
                }

                if(match){
                    index+=len;
                    sb.append(i);
                }else{
                    cnt = cpy;
                }
            }
        }

        return sb.toString();
    }

    public String originalDigits(String s) {
        String[] words = {"zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine"};
        int[] nums = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        int[] distinct_char = {'z', 'w', 'u', 'x', 'g', 'o', 'r', 'f', 'v', 'i'};


        int[] counts = new int[26];
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            int count = counts[distinct_char[i]-'a'];
            for(int j=0;j<words[i].length();j++){
                counts[words[i].charAt(j)-'a']-=count;
            }
            while(count--!=0){
                sb.append(nums[i]);
            }
        }

        char[] nums_str = sb.toString().toCharArray();
        Arrays.sort(nums_str);
        return new String(nums_str);
    }
}
