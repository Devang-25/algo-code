/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mns
 */
public class RepeatedDNA {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> out = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len - 9; i++) {
            String currSeq = s.substring(i, i + 10);
            Integer val = map.get(currSeq);
            if (val == null) {
                map.put(currSeq, 1);
            } else {
                map.put(currSeq, val + 1);
            }
        }

        for (String seq : map.keySet()) {
            if (map.get(seq) > 1) {
                out.add(seq);
            }
        }

        return out;
    }
}
