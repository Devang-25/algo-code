package leet.may30day;

public class FirstUniqueCharacter {
  public int firstUniqChar(String s) {
    int[] count = new int[26];
    for (char ch : s.toCharArray()) {
      count[ch - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
      if (count[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    FirstUniqueCharacter f = new FirstUniqueCharacter();
    System.out.println(f.firstUniqChar("leetcode"));
    System.out.println(f.firstUniqChar("loveleetcode"));
  }
}
