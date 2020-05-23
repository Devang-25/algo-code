package leet.may30day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    if (p.length() > s.length()) {
      return result;
    }

    int[] pCount = new int[26];
    int[] windowCount = new int[26];
    int pLen = p.length();
    for (int i = 0; i < p.length(); i++) {
      pCount[p.charAt(i) - 'a']++;
      windowCount[s.charAt(i) - 'a']++;
    }
    if (Arrays.compare(pCount, windowCount) == 0) {
      result.add(0);
    }
    for (int i = pLen; i < s.length(); i++) {
      windowCount[s.charAt(i) - 'a']++;
      windowCount[s.charAt(i - pLen) - 'a']--;

      if (Arrays.compare(pCount, windowCount) == 0) {
        result.add(i - pLen + 1);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    FindAllAnagrams f = new FindAllAnagrams();
    f.findAnagrams("cbaebabacd", "abc").stream().forEach(System.out::print);
    f.findAnagrams("abab", "ab").stream().forEach(System.out::print);
  }
}
