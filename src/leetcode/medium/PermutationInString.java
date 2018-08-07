package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mns on 8/6/18.
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() > s2.length()){
            return false;
        }

        int l1 = s1.length(), l2 = s2.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<l1;i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }

        for(int i=0;i<l1;i++){
            Integer val = map.get(s2.charAt(i));
            if(val != null){
                map.put(s2.charAt(i),val-1);
            }
        }
        int i = 0;
        for(int j=l1;j<l2;j++){
            if(isAllZeros(map)){
                return true;
            }
            if(map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i),map.get(s2.charAt(i))+1);
            }
            if(map.containsKey(s2.charAt(j))){
                map.put(s2.charAt(j),map.get(s2.charAt(j))-1);
            }
            i++;
        }
        return isAllZeros(map);
    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    private boolean isAllZeros(HashMap<Character,Integer> map){
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PermutationInString ps = new PermutationInString();
        System.out.println(ps.checkInclusion("adc","dcda"));
    }
}
