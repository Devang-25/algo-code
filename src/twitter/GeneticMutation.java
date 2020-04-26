/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mns
 */
public class GeneticMutation {

    static HashMap<String, Integer> dict = new HashMap<String, Integer>();
    static String endString = null;
    static final char[] STRANDS = {'A', 'C', 'T', 'G'};
    static int minChanges = Integer.MAX_VALUE;

    static int findMutationDistance(String start, String end, String[] bank) {
        endString = end;
        for (int i = 0; i < bank.length; i++) {
            dict.put(bank[i], 1);
        }
        HashMap<String, Integer> pathMap = new HashMap<>();
        pathMap.put(start, 1);
        findMutationUtil(new StringBuilder(start), pathMap, 0);
        return minChanges == Integer.MAX_VALUE ? -1 : minChanges;
    }

    static void findMutationUtil(StringBuilder start, HashMap<String, Integer> pathMap, int currChanges) {

        if (dict.containsKey(start.toString()) && start.toString().contentEquals(endString)) {
            if (minChanges > currChanges) {
                minChanges = currChanges;
                return;
            }
        }

        int len = start.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < STRANDS.length; j++) {
                if (start.charAt(i) != STRANDS[j]) {
                    StringBuilder newBuilder = new StringBuilder(start);
                    newBuilder.setCharAt(i, STRANDS[j]);
                    if (!pathMap.containsKey(newBuilder.toString()) && dict.containsKey(newBuilder.toString())) {
                        pathMap.put(newBuilder.toString(), 1);
                        findMutationUtil(newBuilder, pathMap, currChanges + 1);
                        pathMap.remove(newBuilder.toString());
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = "out.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }

        String _end;
        try {
            _end = in.nextLine();
        } catch (Exception e) {
            _end = null;
        }

        int _bank_size = 0;
        _bank_size = Integer.parseInt(in.nextLine().trim());
        String[] _bank = new String[_bank_size];
        String _bank_item;
        for (int _bank_i = 0; _bank_i < _bank_size; _bank_i++) {
            try {
                _bank_item = in.nextLine();
            } catch (Exception e) {
                _bank_item = null;
            }
            _bank[_bank_i] = _bank_item;
        }

        res = findMutationDistance(_start, _end, _bank);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
        in.close();
    }
}
