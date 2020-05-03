package leet.may30day;

import java.util.Set;
import java.util.stream.Collectors;

public class JewelsAndStones {
  public int numJewelsInStones2(String j, String s) {
    Set<Integer> set = j.chars().boxed().collect(Collectors.toSet());
    return s.chars().reduce(0, (total, c) -> set.contains(c) ? total + 1 : total);
  }

  public int numJewelsInStones(String j, String s) {
    boolean[] arr = new boolean[256];
    for (int i = 0; i < j.length(); i++) {
      arr[j.charAt(i) - 'A'] = true;
    }
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (arr[s.charAt(i) - 'A']) {
        result++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    JewelsAndStones j = new JewelsAndStones();
    System.out.println(j.numJewelsInStones2("aA", "aAAbbbb"));
    System.out.println(j.numJewelsInStones("aA", "aAAbbbb"));
  }
}
