package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mns on 9/18/18.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Set<Character>[] adjList = new Set[26];
        int[] visited = new int[26];
        StringBuilder sb = new StringBuilder();

        if(words.length == 1){
            return words[0];
        }
        
        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1];
            String s2 = words[i];
            int x = 0, minLength = Math.min(s1.length(), s2.length());
            for (int j = 0; j < s1.length(); j++) {
                if (adjList[s1.charAt(j) - 'a'] == null) {
                    adjList[s1.charAt(j) - 'a'] = new HashSet<>();
                }
            }
            for (int j = 0; j < s2.length(); j++) {
                if (adjList[s2.charAt(j) - 'a'] == null) {
                    adjList[s2.charAt(j) - 'a'] = new HashSet<>();
                }
            }

            while (x < minLength && s1.charAt(x) == s2.charAt(x)) {
                x++;
            }

            if (x < minLength) {
                adjList[s1.charAt(x) - 'a'].add(s2.charAt(x));
            }
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] == 0 && adjList[i] != null && adjList[i].size() > 0) {
                StringBuilder temp = new StringBuilder();
                boolean noCycle = dfs(visited,(char)(i+'a'),adjList,temp);
                if(!noCycle){
                    return "";
                }
                sb.append(temp);
            }
        }

        for (int j = 0; j < 26; j++) {
            if (visited[j] == 0 && adjList[j] != null) {
                sb.append((char) (j + 'a'));
                visited[j] = 2;
            }
        }
        return sb.reverse().toString();


    }

    private boolean dfs(int [] visited, char ch, Set<Character> [] adjList, StringBuilder temp){
        visited[ch-'a'] = 1;
        for(char neighbor : adjList[ch-'a']){
            if(visited[neighbor-'a'] == 0){
                if(!dfs(visited,neighbor,adjList,temp)){
                    return false;
                }
            }else if(visited[neighbor-'a'] == 1){
                return false;
            }
        }
        visited[ch-'a'] = 2;
        temp.append(ch);
        return true;
    }

    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();
        System.out.println(ad.alienOrder(new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"}));
        System.out.println(ad.alienOrder(new String[]{"z",
                "x"}));
        System.out.println(ad.alienOrder(new String[]{"z",
                "x",
                "z"}));
        System.out.println(ad.alienOrder(new String[]{"ax",
                "ab"}));
        System.out.println(ad.alienOrder(new String[]{"abasdfsadf",
                "abasdfsadf"}));
        System.out.println(ad.alienOrder(new String[]{"ac","ab","b"}));
        System.out.println(ad.alienOrder(new String[]{"a", "b", "ca"}));
        System.out.println(ad.alienOrder(new String[]{"z", "x", "z"}));
    }
}
