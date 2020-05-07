package leet.may30day;

public class RansomNote {
    public boolean canContrtuct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;

        int [] cnt = new int[26];
        for(char ch : magazine.toCharArray()){
            cnt[ch - 'a']++;
        }
        for(char ch : ransomNote.toCharArray()){
            cnt[ch - 'a']--;
            if(cnt[ch - 'a'] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canContrtuct("a", "b"));
        System.out.println(rn.canContrtuct("aa", "ab"));
        System.out.println(rn.canContrtuct("aa", "aab"));
    }
}