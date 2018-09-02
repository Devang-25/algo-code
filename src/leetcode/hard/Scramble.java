package leetcode.hard;

public class Scramble {
    public boolean isScramble(String s1, String s2) {
        if(s1.contentEquals(s2)){
            return true;
        }
        if(s1.length() != s2.length()){
            return false;
        }

        int [] map = new int[26];
        int len = s1.length();
        for(int i=0;i<len;i++){
            map[s1.charAt(i)-'a']++;
            map[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(map[i] != 0){
                return false;
            }
        }

        for(int i=1;i<= len-1;i++){
            if( isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if( isScramble(s1.substring(0,i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0,len-i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scramble sb = new Scramble();
        System.out.println(sb.isScramble("rgeat", "great"));
        System.out.println(sb.isScramble("abcde", "caebd"));
        System.out.println(sb.isScramble("abb", "bba"));
    }
}
