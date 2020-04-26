/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmware;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author mns
 */
public class HackLand {

    static String electionWinner(String[] votes) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < votes.length; i++) {
            Integer val = map.get(votes[i]);
            if (val == null) {
                map.put(votes[i], 1);
            } else {
                map.put(votes[i], val + 1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        String max_name="";
        for (String str : map.keySet()) {
            if(map.get(str) > max){
                max = map.get(str);
                max_name = str;
            }
        }
        
        return max_name;

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;

        int _votes_size = 0;
        _votes_size = Integer.parseInt(in.nextLine().trim());
        String[] _votes = new String[_votes_size];
        String _votes_item;
        for (int _votes_i = 0; _votes_i < _votes_size; _votes_i++) {
            try {
                _votes_item = in.nextLine();
            } catch (Exception e) {
                _votes_item = null;
            }
            _votes[_votes_i] = _votes_item;
        }

        res = electionWinner(_votes);
        bw.write(res);
        bw.newLine();

        bw.close();
        in.close();
    }

}
