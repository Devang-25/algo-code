package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordLadder2 {
    private int shortestLength;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        shortestLength = ladderLength(beginWord,endWord,wordList);
        List<List<String> > result = new ArrayList<>();
        boolean [] taken = new boolean[wordList.size()];
        ArrayList<String> curr = new ArrayList<>();
        curr.add(beginWord);
        util(beginWord, endWord, wordList, result, curr , taken);
        return result;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : wordList) {
            map.put(s, Boolean.FALSE);
        }

        if(map.get(endWord) == null){
            return 0;
        }


        ArrayDeque<String> q = new ArrayDeque<String>();
        q.offerLast(beginWord);
        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            length++;
            for (int i = 0; i < size; i++) {
                String str = q.pollFirst();
                for (int j = 0; j < str.length(); j++) {
                    StringBuilder currWord = new StringBuilder(str);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currWord.setCharAt(j, ch);
                        String cws = currWord.toString();
                        if(cws.contentEquals(endWord)){
                            return length+1;
                        }

                        if (map.containsKey(cws)
                                && map.get(cws) == Boolean.FALSE) {
                            map.put(cws, Boolean.TRUE);
                            q.offerLast(cws);
                        }
                    }
                }

            }

        }

        return 0;
    }

    private void util(String begin, String end, List<String> wordList, List<List<String>> result, ArrayList<String> curr, boolean [] taken){
        if(curr.size() > shortestLength){
            return;
        }

        if(curr.get(curr.size()-1).contentEquals(end)){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<wordList.size();i++){
            if(!taken[i]) {
                if (is1Diff(begin, wordList.get(i))) {
                    taken[i] = true;
                    curr.add(wordList.get(i));
                    util(wordList.get(i),end,wordList,result,curr,taken);
                    curr.remove(curr.size()-1);
                    taken[i] = false;
                }
            }
        }
    }

    private boolean is1Diff(String a, String b ){
        boolean flag = false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                if(!flag){
                    flag = true;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
