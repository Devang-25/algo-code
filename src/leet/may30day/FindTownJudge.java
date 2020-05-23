package leet.may30day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class FindTownJudge {
  public int findJudge(int N, int[][] trust) {
    if (trust.length == 0) {
      return 1;
    }
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    HashMap<Integer, Boolean> outDegree = new HashMap<>();
    for (int[] t : trust) {
      HashSet<Integer> trusts = map.computeIfAbsent(t[1], (key) -> new HashSet<>());
      outDegree.put(t[0], true);

      // Don't add self edges.
      if (t[0] != t[1]) {
        trusts.add(t[0]);
      }
    }

    for (Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
      if (entry.getValue().size() == N - 1 && outDegree.get(entry.getKey()) == null) {
        return entry.getKey();
      }
    }

    return -1;
  }

  public int findJudge2(int N, int[][] trust) {
    int[] trustOthers = new int[N + 1];
    int[] othersTrust = new int[N + 1];
    for (int[] edge : trust) {
      trustOthers[edge[0]]++;
      othersTrust[edge[1]]++;
    }

    for (int i = 1; i <= N; i++) {
      if (trustOthers[i] == 0 && othersTrust[i] == N - 1)
        return i;
    }

    return -1;
  }

  public static void main(String[] args) {
    FindTownJudge ftj = new FindTownJudge();
    System.out.println(ftj.findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } }));
  }
}
