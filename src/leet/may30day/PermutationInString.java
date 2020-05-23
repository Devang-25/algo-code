package leet.may30day;

import java.util.Arrays;

public class PermutationInString {
  public boolean checkInclusion2(String p, String s) {
    if (p.length() > s.length()) {
      return false;
    }

    int[] pCount = new int[26];
    int[] windowCount = new int[26];
    int pLen = p.length();
    for (int i = 0; i < p.length(); i++) {
      pCount[p.charAt(i) - 'a']++;
      windowCount[s.charAt(i) - 'a']++;
    }
    if (Arrays.compare(pCount, windowCount) == 0) {
      return true;
    }
    for (int i = pLen; i < s.length(); i++) {
      windowCount[s.charAt(i) - 'a']++;
      windowCount[s.charAt(i - pLen) - 'a']--;

      if (Arrays.compare(pCount, windowCount) == 0) {
        return true;
      }
    }

    return false;
  }

  public boolean checkInclusion(String s1, String s2) {
    int[] counts = new int[128];
    for (int i = 0; i < s1.length(); i++) {
      counts[s1.charAt(i)]++;
    }
    int n = s1.length();

    int left = 0;
    int right = 0;
    char[] arr = s2.toCharArray();
    while (right < arr.length) {
      while (right < arr.length && counts[arr[right]] > 0) {
        counts[arr[right]]--;
        right++;
      }

      if (right - left == n)
        return true;

      while (right < arr.length && counts[arr[right]] <= 0) {
        counts[arr[left++]]++;
      }

    }

    return false;
  }
}
